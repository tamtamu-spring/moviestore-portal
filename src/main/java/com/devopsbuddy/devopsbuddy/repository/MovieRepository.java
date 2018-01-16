package com.devopsbuddy.devopsbuddy.repository;

import com.devopsbuddy.devopsbuddy.web.controller.domain.frontend.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {

    Iterable<Movie> findAll();
}
