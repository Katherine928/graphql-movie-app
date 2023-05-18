# graphql-movie-app

Project Name is a Java Spring Boot application that demonstrates the usage of GraphQL for building a GraphQL API.

## Features

- Exposes a GraphQL API for performing CRUD operations on entities.
- Implements data fetching and manipulation using GraphQL queries and mutations.
- Utilizes Spring Boot framework for easy setup and configuration.

## Technologies Used

- Java
- Spring Boot
- GraphQL
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven

### Installation

1. Clone the repository:

```
git clone https://github.com/Katherine928/graphql-movie-app.git
```

2. Navigate to the project directory:

```
cd project-name
```

3. Build the project using Maven:

```
mvn clean install
```

4. Run the application:

```
java -jar target/graphql-movie-app.jar
```

5. Access the GraphQL API at `http://localhost:8080/graphql`.

## Usage

### GraphQL API

The GraphQL API endpoint is located at `http://localhost:8080/graphql`.

You can use tools like [GraphiQL](https://github.com/graphql/graphiql) or [GraphQL Playground](https://github.com/prisma/graphql-playground) to interact with the API and execute queries and mutations.

#### Example Queries

##### Fetch all entities

```graphql
query {
  entities {
    id
    name
    # Additional fields
  }
}
```

##### Fetch a single entity

```graphql
query {
  entity(id: 1) {
    id
    name
    # Additional fields
  }
}
```

#### Example Mutations

##### Create an entity

```graphql
mutation {
  createEntity(input: {
    name: "New Entity"
    # Additional fields
  }) {
    id
    name
    # Additional fields
  }
}
```

##### Update an entity

```graphql
mutation {
  updateEntity(id: 1, input: {
    name: "Updated Entity"
    # Additional fields
  }) {
    id
    name
    # Additional fields
  }
}
```

##### Delete an entity

```graphql
mutation {
  deleteEntity(id: 1) {
    id
    name
    # Additional fields
  }
}
```

## Configuration

The application's configuration can be modified in the `application.properties` file located in the `src/main/resources` directory.

## Contributing

Contributions are welcome! If you find any issues or want to add new features, feel free to submit a pull request.

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [GraphQL](https://graphql.org/)

Feel free to customize this README file according to your specific project's needs. Provide additional information about your project's structure, setup instructions, or any other relevant details.