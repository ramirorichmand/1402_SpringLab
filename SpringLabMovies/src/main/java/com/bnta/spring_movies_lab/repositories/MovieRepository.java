package com.bnta.spring_movies_lab.repositories;

import com.bnta.spring_movies_lab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByDurationLessThan(int maxDuration);
}
