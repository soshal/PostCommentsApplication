ost-Comments Service
A simple Spring Boot application that allows users to create posts and add comments to those posts.

Features
Create text-based posts

Add comments to posts

View all posts

View all comments for a specific post



H2 in-memory database with web console

Basic input validation

Error handling

Technologies
Java 11

Spring Boot 2.7.x

Spring Data JPA

H2 Database

Maven

Swagger (OpenAPI 3.0)

Setup Instructions
Prerequisites
Java JDK 11 or higher

Maven 3.6.x or higher

Installation
Clone the repository:

bash
git clone https://github.com/yourusername/post-comments-service.git
cd post-comments-service
Build the application:

bash
mvn clean install
Run the application:

bash
mvn spring-boot:run
Accessing the Application
The application will start on port 8080 by default.

API Endpoints
Posts:

GET /api/posts - Get all posts

GET /api/posts/{id} - Get a specific post

POST /api/posts - Create a new post

Comments:

GET /api/posts/{postId}/comments - Get all comments for a post

POST /api/posts/{postId}/comments - Create a new comment for a post

API Documentation
Swagger UI is available at:
http://localhost:8080/swagger-ui.html

Database Console
H2 database console is available at:
http://localhost:8080/h2-console

Connection details:

JDBC URL: jdbc:h2:mem:postcommentsdb

Username: sa

Password: (leave empty)

Request Examples
Create a Post
bash
curl -X POST "http://localhost:8080/api/posts" \
-H "Content-Type: application/json" \
-d '{
    "title": "My First Post",
    "content": "This is the content of my first post."
}'
Create a Comment
bash
curl -X POST "http://localhost:8080/api/posts/1/comments" \
-H "Content-Type: application/json" \
-d '{
    "text": "This is a comment on the first post."
}'
Project Structure
text
src/main/java/com/example/postcomments/
├── PostCommentsApplication.java         # Main application class
├── controllers/                        # REST controllers
│   ├── CommentController.java
│   └── PostController.java
├── entities/                           # JPA entities
│   ├── Comment.java
│   └── Post.java
├── exceptions/                         # Exception handling
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
├── repositories/                       # Data repositories
│   ├── CommentRepository.java
│   └── PostRepository.java
├── requests/                           # Request DTOs
│   ├── CommentCreate.java
│   └── PostCreate.java
└── services/                           # Business logic
    ├── CommentService.java
    └── PostService.java
Configuration
The application uses an H2 in-memory database by default. Configuration can be modified in src/main/resources/application.properties.

Running Tests
To run the unit tests:

bash
mvn test
License
This project is licensed under the MIT License.
