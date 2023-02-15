package com.bnta.spring_movies_lab.services;

import com.bnta.spring_movies_lab.models.Movie;
import com.bnta.spring_movies_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService() {

    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).get();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getMoviesByMaxDuration(int maxDuration) {
        return movieRepository.findByDurationLessThan(maxDuration);
    }

    public void updateMovie(int id, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setRating(updatedMovie.getRating());
            movie.setDuration(updatedMovie.getDuration());
            movieRepository.save(movie);
        }
    }

    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }

}
