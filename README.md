# rest-url-shortener

A simple REST API for shortening URLs.

#### Project Architecture:
- The project currently uses a MySQL database for storing the data for the shortened URLs, and a Redis Database for caching the data in under to make the responses faster.
- The API is implemented in the Spring Boot framework using Java.

You can find the detailed API documentation created by Swagger UI here: `/api-docs.html`, but here is a quick overview of the most important endpoints:

### Most Important Endpoints:

#### 1. POST `/`: Creates a new shortened URL based on an original url provided in the request body
- Request body:
```
{
"url": "https://example.com/some/very/long/path?with=params"
}
```
- Response: 200 OK, Returns a string containing the shortened url.

#### 2. GET `/{id}`: Resolves a shortened URL
- Response: 200 OK, Returns a string with the original URL.