package com.gfg.shoutreview.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfg.shoutreview.Entity.Genre;
import com.gfg.shoutreview.Entity.Movie;


public interface MovieRepository  extends JpaRepository<Movie,Long>{
	 public Movie findByTitle(String title);

	    public List<Movie> findByGenre(Genre genre);
}
