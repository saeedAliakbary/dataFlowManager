# DataFlowManager

DataFlowManager is a Spring Boot application designed to manage objects and their associated main tables and calculation tables. It uses PostgreSQL as the database, Hibernate for ORM, Flyway for database migrations, and Envers for auditing.

## Features

- CRUD operations for ObjectDocuments.
- Pagination, sorting, and search functionality for listing ObjectDocuments.
- Basic authentication for data modification operations.
- Validation using Spring annotations and custom validators.
- Auditing with metadata fields (created date, last modified date, created by, last modified by).
- History tracking with Hibernate Envers.
- Flyway for database migrations.
- Docker support for PostgreSQL.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Docker

### Installing

1. **Clone the repository:**
    ```sh
    git clone https://github.com/your-username/DataFlowManager.git
    cd DataFlowManager
    ```

2. **Build the project:**
    ```sh
    mvn clean install
    ```

3. **Run PostgreSQL using Docker:**
    ```sh
    docker run --name postgres-db -e POSTGRES_DB=your_database_name -e POSTGRES_USER=your_username -e POSTGRES_PASSWORD=your_password -p 5432:5432 -d postgres:14
    ```

4. **Configure the application:**
   Update the `src/main/resources/application.properties` file with your database configuration:
    ```properties
    # Spring Datasource
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=org.postgresql.Driver

    # Hibernate JPA Configuration
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update

    # Show SQL statements in the logs
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=true

    # Flyway configuration
    spring.flyway.enabled=true
    spring.flyway.locations=classpath:db/migration

    # Envers configuration
    spring.jpa.properties.hibernate.envers.audit_table_prefix = AUDIT_
    spring.jpa.properties.hibernate.envers.audit_table_suffix = _AUD
    spring.jpa.properties.hibernate.envers.revision_field_name = rev
    spring.jpa.properties.hibernate.envers.revision_type_field_name = revtype
    spring.jpa.properties.hibernate.envers.store_data_at_delete = true
    ```

5. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```

## Usage

### API Endpoints

- **List ObjectDocuments**: `GET /api/objectdocuments`
    - Supports pagination, sorting, and search by name.
- **Create ObjectDocument**: `POST /api/objectdocuments`
    - Requires authentication.
- **View ObjectDocument**: `GET /api/objectdocuments/{id}`
- **Edit ObjectDocument**: `PUT /api/objectdocuments/{id}`
    - Requires authentication.
- **Delete ObjectDocument**: `DELETE /api/objectdocuments/{id}`
    - Requires authentication.

### Basic Authentication

Endpoints for creating, editing, and deleting ObjectDocuments require HTTP Basic Authentication. Configure the authentication settings in the `src/main/resources/application.properties` file.

## Running Tests

To run the tests, use the following command:
```sh
mvn test
