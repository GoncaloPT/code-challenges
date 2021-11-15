# Native images with spring

## Installation - Steps made

1. Setup graalvm
   (using sdkman) sdk use java 21.3.0.r11-grl 
2. install native image
   gu install native-image

## Build and Run 

### Using buildpacks

after doing the required changes:
https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/#getting-started-buildpacks

building image:
`mvn spring-boot:build-image`



### Using native build tools
Native build tools are part of graal vm and by using them one can build an executable file. 

mvn -Pnative -DskipTests package  
or to include database:  
`mvn -Pnative -Ph2 -DskipTests package` or
`native-image --no-server --allow-incomplete-classpath -jar (jarfile) `

To run:  
`target/graal`

- This executable can only be run on the same OS the image was built

### improve spring boot
https://titanwolf.org/Network/Articles/Article?AID=28589818-e9e4-44d9-8596-09dc4a84ef39

### other docs 
https://blogs.oracle.com/developers/post/building-cross-platform-native-images-with-graalvm
