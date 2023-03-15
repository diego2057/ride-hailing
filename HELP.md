# Read Me First
The following was discovered as part of building this project:

* The JVM level was changed from '11' to '17', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.
* The original package name 'com.wompi.ride.hailing.ride-hailing' is invalid and this project uses 'com.wompi.ride.hailing.ridehailing' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.4/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Liquibase Migration](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#howto.data-initialization.migration-tool.liquibase)

### Guides
The following guides illustrate how to use some features concretely:
#### Internal Guides
* Deploy app:
  * Execute in the console next command *docker build -t ride-hailing .* to create the docker image
  * Execute in the console next command *docker run --name ride-hailing -p 8080:8080 -e DB_HOST=db -e DB_USER=myuser -e DB_PASS=mypassword -d ride-hailing* to create the docker container
  * The above steps deploy the app in *http://localhost:8080*
* The database is seed with data from liquibase changelog files
* Test application:
  * Import the [ride-hailing.postman_collection.json](ride-hailing.postman_collection.json) in postman and make a test by each request

#### External Guides
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

