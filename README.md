# 14/02 Lab - The Spring Cinema


Used tools available to integrate an SQL database into the API. Helps improve our cinema experience from the SQL lessons by using an API to save new films instead of writing the queries manually!

## MVP

Created a new Spring Boot project with the `Web`, `DevTools`, `PostgreSQL` and `JPA` dependencies. This formed the basis of my API which needed:

- A `Movie` model with the properties:
	- `id`
	- `title`
	- `rating`
	- `duration` 

With annotations to facilitate database integration.

- A `MovieRepository` to connect the model to the database
- A `MovieController` with the following routes:
	- `GET /movies`
	- `GET /movies/{id}`
	- `POST /movies`
- A `MovieService` to connect the controller and repository

Tested the routes using Postman to ensure I was able to add a new movie and see those already in the database.

## Extensions

- Add functionality to update a movie in the database
- Add functionality to delete a movie from the database

## Advanced Extension

- Use a `@RequestParam` to add a `maxDuration` parameter to the `GET /movies` request. Pass this through to the service and use it to return only the movies with a duration less than the value.
