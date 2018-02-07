package com.tomas.moviechecklist.controller;

import com.tomas.moviechecklist.model.Movie;
import com.tomas.moviechecklist.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomas on 1/18/2018.
 */
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;


    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    @PostMapping("/movies")
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        System.out.println(movie.toString());
        return movieRepository.save(movie);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id") String movieId) {
        Movie movie = movieRepository.findOne(movieId);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(movie);
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") String movieId,
                                             @Valid @RequestBody Movie movieDetails) {
        Movie movie = movieRepository.findOne(movieId);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        movie.setTitle(movieDetails.getTitle());
        movie.setImdbID(movieDetails.getImdbID());
        movie.setImdbURL(movieDetails.getImdbURL());
        movie.setCompleted(movieDetails.isCompleted());
        movie.setTrailerURL(movieDetails.getTrailerURL());
        movie.setGenres(movieDetails.getGenres());
        movie.setLanguages(movieDetails.getLanguages());
        movie.setRunTime(movieDetails.getRunTime());
        movie.setYear(movieDetails.getYear());
        movie.setCreatedAt(new Date());
        movie.setUpdatedAt(new Date());

        Movie updatedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable(value = "id") String movieId) {
        Movie movie = movieRepository.findOne(movieId);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }

        movieRepository.delete(movie);
        return ResponseEntity.ok().build();
    }
}
