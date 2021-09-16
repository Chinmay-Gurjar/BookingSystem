package com.example.bookingsystem.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> getMovieDetails() {
        return movieRepository.findAll();
    }

    public String randomText() {
        return "Something";
    }
}
