FROM maven:3.6.3-jdk-11 as BUILD
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM open-liberty:19.0.0.9-microProfile3-java11
COPY --from=BUILD --chown=1001:0  /tmp/target/*.war /config/dropins/
RUN configure.sh
