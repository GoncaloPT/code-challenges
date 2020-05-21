# Microprofile first tryout

## Goal
The goal of this POC is to try microprofile project  
https://github.com/eclipse/microprofile

Objective list:  
1. Develop and exposed a simple web API ✅
1. Describe using Open API 3 ✅
1. Introduce swaggerUI ✅
1. Run locally using Payara maven plugin ✅
1. Containerize

## Application server
To run the application Payara application server  
https://docs.payara.fish/docs/5.201/README.html

## Useful information

- Run application locally using payara  
`mvn clean package payara-micro:bundle && mvn payara-micro:start`  
You should now have a 200 OK json response from:  
GET http://localhost:8080/microprofile/person/

- Check openapi yaml file  
http://localhost:8080/openapi

- Check swagger ui documentation
http://localhost:8080/microprofile/openapi-ui/index.html
 
## Used references

- https://medium.com/danieldiasjava/conhecendo-o-payara-micro-d4f45eb0f9c2
- https://blog.payara.fish/how-to-run-and-debug-your-payara-micro-application-with-intellij-idea
- https://www.phillip-kruger.com/post/microprofile_openapi_swaggerui/
- https://projects.eclipse.org/projects/technology.microprofile/developer

