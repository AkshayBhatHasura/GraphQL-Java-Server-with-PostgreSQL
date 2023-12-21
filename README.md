# GraphQL Java Server with PostgreSQL

This demo provides an overview of a GraphQL Java server built using the graphql-java library and connected to the Chinook database on PostgreSQL.

Features:

* Exposes a GraphQL API for accessing Chinook music store data.
* Demonstrates initial setup with static data (from the Spring Boot tutorial) and then integration with PostgreSQL.
* Addresses N+1 query problem in GraphQL Java.

Technology Stack:

* Java 21
* Gradle (maven is another option)
* Spring Boot
* graphql-java
* graphql-servlet
* PostgreSQL
* chinook-database (optional)


Getting Started:

* Clone the repository.
* Install Prerequisites:
* Ensure Java 21 is installed and available in your PATH.
* Install Gradle.
* Install and configure PostgreSQL.
* Download the chinook database and place it in the src/main/resources directory (optional).

Build and Run:

* Start docker demon and then initialise a container:
 'docker run -e POSTGRES_PASSWORD=password postgres'

* Copy chinook database to the container:
 'docker cp /path/to/chinook/sql/file <container_id>:/'

* Enter PostgreSQL command line with the user:
 
 'psql -U postgres'

* Create 'chinook' database:
 
 'CREATE DATABASE chinook'

* Load sql data from file:
 '\c chinook'
 and then 
 '\i /path/to/sql/file' 

* Run 'gradle build' and then 'gradle bootRun'.
* Access the GraphQL API server endpoint available at http://localhost:8080/graphiql.

Data:

* Initially, the server uses static data from the tutorial.
* To connect to PostgreSQL and access Chinook data:
* Update the application.properties file with your PostgreSQL connection details.
* Uncomment the @EnableJpaRepositories annotation in Application.java.
* Ensure you have the chinook-database file in the correct location.

N+1 Query Problem:

* The tutorial example demonstrates potential N+1 query problem.
* Implement proper data fetching logic in resolvers to avoid N+1 queries.
* Trying a solution like Hasura which handles N+1 queries is a great way to resolve this.

Contributing:

* Feel free to fork the repository and contribute your improvements.
* Raise issues and pull requests for any bugs or suggestions.

Resources:

* GraphQL Java: https://graphql-java.com/
* Spring Boot: https://spring.io/projects/spring-boot
* graphql-servlet: https://github.com/graphql-java-kickstart/graphql-java-servlet
* PostgreSQL: https://www.postgresql.org/
* Chinook PostgreSQL database: https://github.com/lerocha/chinook-database/blob/master/ChinookDatabase/DataSources/Chinook_PostgreSql.sql

Enjoy exploring and building your own GraphQL Java server with PostgreSQL!

Make sure to try out Hasura to build it much faster!

