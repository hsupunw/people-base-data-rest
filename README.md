# Project people-base-data-rest
- This is a sample sapring-boot based REST application which shows main crud operations in person entities that is implemented with spring-data-rest 
- More over it is protected by basic authentication supported by spring-security.
- It additonally, provides related hateos navigation links for each endpoint response.

## Build
You can build the project with following steps
- Navigate to project root. */people-base/
- Execute a maven build by 
```shell
mvn clean package
```
or 
```shell
mvn clean install
```
- Find the executable .jar at */people-base/target/

## Test without installing
- Alternately you can download the executable .jar file directly from *******

## Run
- With the executable .jar made with the previous step, you can run the application by 
```shell
java -jar people-base-data-rest-0.0.1-SNAPSHOT.jar
```
command.
- By Default it uses port 8080.

## Authentication 
- This application is secured by basic authentication. So whenever asked please submit following credentials
    - user name: admin
    - password: admin

## H2 Console
- This application uses an in memory h2 db. To navigate to h2 console, go http://localhost:8080/h2-console
    - user name: sa
    - password:

## Command line client (curl)
- Below, you can can find sample basic curl command collection to test this application. 
- Get all
```shell
 curl --user admin:admin localhost:8080/persons
```
- Get one
```shell
 curl --user admin:admin localhost:8080/persons/123
```
- Create
```shell
 curl --user admin:admin -X POST localhost:8080/persons -H 'Content-type:application/json' -d '{
  "age": 54,
  "favourite_colour": "blue",
  "first_name": "Sarah",
  "hobby": [
    "chess"
  ],
  "last_name": "Robinson"
}'
```
- Update
```shell
 curl --user admin:admin -X PUT localhost:8080/persons/123 -H 'Content-type:application/json' -d '{
  "first_name": "John",
  "last_name": "Keynes",
  "age": 29,
  "favourite_colour": "black",
  "hobby": [
    "cricket"
   ]
}'
```
- Delete
```shell
 curl --user admin:admin -X DELETE localhost:8080/persons/123
```

## Postman Collection
- You can import the postman collection created for testing purpose from https://www.getpostman.com/collections/3582526d271489102986
    
## Front End client
- A front end client using angular 7 is developed for ease of use. Please find it from https://github.com/hsupunw/people-client

## Alternative Implementation with spring-data-rest
- An alternative implementation with spring-mvc (fully working with above angular front end) can be found from https://github.com/hsupunw/people-base
