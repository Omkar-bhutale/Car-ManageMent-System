This project is a Car Management System built using Spring Boot and Maven. It provides a RESTful API to manage car information, including adding, updating, deleting, and searching for cars. The project uses Spring Data JPA for database interactions and Hibernate as the ORM framework.  Key features include:  
CRUD Operations: Endpoints to create, read, update, and delete car records.
Search Functionality: Endpoints to search cars by name, model, year, fuel type, and color.
Validation: Input validation using Jakarta Validation.
Exception Handling: Global exception handling with custom exceptions for car not found and car already exists scenarios.
Swagger Integration: API documentation and testing using springdoc-openapi and Swagger UI.
Logging: Logging of operations using SLF4J and Logback.
MySQL Database: Integration with MySQL for data persistence.
The project structure includes:  
controller: REST controllers for handling HTTP requests.
service: Service layer interfaces and implementations.
model: Entity classes representing the database schema.
exception: Custom exception classes and global exception handler.
configuration: Configuration classes for setting up Swagger and other components.
To run the project, configure the database settings in application.properties, build the project using Maven, and start the Spring Boot application. The Swagger UI can be accessed at 
http://localhost:8080/swagger-ui.html 
for API documentation and testing.
