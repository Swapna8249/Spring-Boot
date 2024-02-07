package com.gfg.shoutreview.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfg.shoutreview.Entity.Genre;
import com.gfg.shoutreview.Entity.Movie;
import com.gfg.shoutreview.Repository.MovieRepository;
import com.gfg.shoutreview.Service.response.MovieResponse;
import org.springframework.util.CollectionUtils;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public MovieResponse findMovie(String title) {
        //write fetch from repo.
        // handle not exist scenarios
        //caching logic
        //exception handling
        Movie movie = movieRepository.findByTitle(title);
        if (Objects.nonNull(movie))
            return movie.toMovieResponse();
        return null;
    }

    public List<MovieResponse> findMoviesByGenre(String genre) {
        if (Arrays.stream(Genre.values()).noneMatch(g -> g.toString().equals(genre)))
            return new ArrayList<>();
        List<Movie> movieList = movieRepository.findByGenre(Genre.valueOf(genre));
        if (!CollectionUtils.isEmpty(movieList)) {
            List<MovieResponse> movieResponseList = movieList.stream().sorted(Comparator.comparing(Movie::getRating, Comparator.reverseOrder())).map(m -> m.toMovieResponse()).collect(Collectors.toList());
            if (movieResponseList.size() > 5)
                return movieResponseList.subList(0, 4);
            return movieResponseList;
        }
        return new ArrayList<>();
    }


}