# Quotation-System
### This project was made as part of the kameleoon test task
The project utilizes various technologies including:
> Java 17, Spring Boot, Spring Cloud, Gradle, PostgreSQL, Spring Data JPA, Zipkin, Eureka Server, REST, Flyway, Docker.
## Docker Hub Repository

[Anton Kuchinsky Quotation System Docker Hub Repository](https://hub.docker.com/repository/docker/antonkuchinsky/quotation_system/general)

### Deployment Commands

```bash
docker push antonkuchinsky/quotation_system:postgres
docker push antonkuchinsky/quotation_system:zipkin
docker push antonkuchinsky/quotation_system:gateway-service
docker push antonkuchinsky/quotation_system:discovery-service
docker push antonkuchinsky/quotation_system:user-service
docker push antonkuchinsky/quotation_system:quote-service
docker push antonkuchinsky/quotation_system:voting-service
```
###Local Deployment using Docker Compose
You can also deploy locally by navigating to the project directory and executing the following command in the terminal:
```bash
docker-compose up --build
```
### Application architecture
>![Image alt](https://github.com/antonkuchinsky/Quotation-system/schema.png)

### Discovery Service
>![Image alt](https://github.com/antonkuchinsky/Quotation-system/discovery-image.png)
This service is implemented for service discovery.

### Gateway Service
The Gateway Service serves as the single entry point into the application, handling all client requests by interacting with other services, discovering them through the Discovery Service using their names.

### User Service

The User Service is designed to store user information. It includes the following methods:

- `POST /api/v1/users/register`: Endpoint for user registration
- `GET /api/v1/users/{username}`: Endpoint for retrieving a user by username

### Quote Service

The Quote Service is responsible for storing and managing quotes. This service synchronously communicates with the Voting Service and User Service over HTTP to obtain specific information. It includes the following methods:

- `GET /api/v1/quotes/{id}`: Endpoint for retrieving a quote by its ID
- `GET /api/v1/quotes/top/best`: Endpoint for retrieving the top 10 quotes based on votes
- `GET /api/v1/quotes/top/worst`: Endpoint for retrieving the bottom 10 quotes based on votes
- `GET /api/v1/quotes/random`: Endpoint for retrieving a random quote
- `GET /api/v1/quotes`: Endpoint for retrieving all quotes with pagination
- `POST /api/v1/quotes/create`: Endpoint for creating a quote
- `PATCH /api/v1/quotes/update`: Endpoint for updating a quote
- `DELETE /api/v1/quotes/{id}`: Endpoint for deleting a quote by its ID. This also automatically deletes all associated votes.

### Voting Service

The Voting Service is responsible for storing user voting information. It includes the following methods:

- `GET /api/v1/votes/{quoteId}`: Endpoint for retrieving a list of user votes for a given quote
- `POST /api/v1/votes`: Endpoint for voting for a quote
- `DELETE /api/v1/votes/{quoteId}`: Endpoint for deleting all votes for a given quote
