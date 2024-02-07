package com.gfg.shoutreview.Service;

import org.springframework.stereotype.Service;

import com.gfg.shoutreview.Entity.Movie;
import com.gfg.shoutreview.Repository.MovieRepository;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    //constructor injection
    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}