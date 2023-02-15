package com.bnta.spring_movies_lab.controllers;

import com.bnta.spring_movies_lab.models.Movie;
import com.bnta.spring_movies_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam int maxDuration) {
        List<Movie> movies = movieService.getMoviesByMaxDuration(maxDuration);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie addedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie) {
        movieService.updateMovie(id, updatedMovie);
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
