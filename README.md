# tomweb-backend-application-blog-rest-services
This project is part of the backend development exam for TomasinoWeb.
This blog API uses Java Maven, Spring Boot, and MySQL.
Also included are ThymeLeaf dependencies for front-end development of this API, but not continued.

## Preliminaries
A MySQL Schema (MySQL 8.0 or above) is needed to run the API. In the project folders, access application.properties found in path below

blogapi\blogapi\src\main\resources

Use the following values to connect the API with your MySQL database successfully:

spring.datasource.url=jdbc:mysql://localhost:[MySQL PORT]/[SCHEMA_NAME]?useSSL=false&serverTimezone=UTC

spring.datasource.username=[YOUR_SQL_USERNAME]

spring.datasource.password=[YOUR_SQL_PASSWORD]

spring.jpa.hibernate.ddl-auto=update

Note:
A schema alone will suffice

An installation of Maven is also needed to run the API, along with JDK 17 or higher. 
Read more on installation here: 

https://maven.apache.org/install.html

https://docs.oracle.com/en/java/javase/20/install/overview-jdk-installation.html

Also worthy to note is that Postman is the leading testing software for HTTPS methods and the API.
Read more here:

https://www.postman.com/downloads/

## Usage
You can use an IDE like IntelliJ to open this project and build the Spring Boot, JPA, and MySQL dependencies. Run the program and check the command line to see if the program ran without any errors.
Tomcat is the default server of Spring Boot, and it will likely run on port 8080.
Using Postman, you can go http://localhost:8080/ , and start appending the URL with the HTTPS methods defined in the API.
JPA will automatically create the tables along with the primary keys, as long as the schema is provided in MySQL. 
Do not forget to edit application.properties with the values in the Preliminaries section.

## Features
* Create a post
* View one post or all posts
* Edit post
* Delete post along with any comments
* Add a comment under a post
* Edit a comment under a post
* Delete a comment under a post

## End
This project is partly done as a deliverable for TomasinoWeb's Backend Development Exam. I acknowledge that all submitted works shall be considered property of TomasinoWeb.
