# Java Virtual Thread Demo Application

This Spring Boot application demonstrates the usage of Virtual Threads (Project Loom) in Java. The application implements different service layers to compare the performance between platform threads and virtual threads.

## Features

- REST APIs with both Platform Thread and Virtual Thread implementations
- Sample Customer entity with 2000 sample records
- Four different regions with 500 customers each
- Performance comparison between Platform and Virtual Threads

## Prerequisites

- Java 21 or higher (for Virtual Thread support)
- Maven
- MySQL Database

## Configuration

The application uses MySQL database. Update the database configuration in `application.properties` if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/virtual_thread
spring.datasource.username=root
spring.datasource.password=Password
```

## Database Setup

The database will be automatically created when you start the application. Sample data (2000 customers) will be automatically loaded through the DataLoader class.

## Project Structure

- `controller/` - REST controllers
- `service/` - Service implementations (Platform Thread and Virtual Thread versions)
- `entity/` - JPA entities
- `repository/` - Spring Data JPA repositories
- `config/` - Configuration classes including DataLoader
- `util/` - Utility classes

## Building and Running

To build the project:
```bash
mvn clean install
```

To run the application:
```bash
mvn spring-boot:run
```

The application will start on port 9191 by default.

## Data Distribution

The sample data is distributed as follows:
- 500 customers in North America
- 500 customers in Europe
- 500 customers in Asia
- 500 customers in Australia

Total: 2000 customers

## Performance Testing

You can compare the performance between platform threads and virtual threads by using the different service implementations provided in the application.

## License

This project is licensed under the MIT License.
