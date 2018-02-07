package com.tomas.moviechecklist.repository;

import com.tomas.moviechecklist.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tomas on 1/18/2018.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
}
