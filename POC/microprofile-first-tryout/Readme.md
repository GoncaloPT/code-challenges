# Microprofile first tryout

## Goal
The goal of this POC is to try microprofile project  
https://github.com/eclipse/microprofile

Objective list:  
1. Develop and exposed a simple web API ✅
1. Describe using Open API 3 ✅
1. Introduce swaggerUI
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

 

