package com.devopsbuddy.devopsbuddy.service.movies;

import com.devopsbuddy.devopsbuddy.repository.MovieRepository;
import com.devopsbuddy.devopsbuddy.web.controller.domain.frontend.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {

    @Autowired
    MovieRepository movieRepository;

    public Iterable<Movie> findAll()
    {
        return movieRepository.findAll();

    }

}
