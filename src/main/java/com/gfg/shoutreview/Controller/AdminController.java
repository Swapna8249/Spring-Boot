package com.gfg.shoutreview.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gfg.shoutreview.Service.AdminService;
import com.gfg.shoutreview.Service.request.MovieRequest;
import com.gfg.shoutreview.Service.response.MovieResponse;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("movie/add")
    public ResponseEntity<MovieResponse> addMovie(@RequestBody MovieRequest movieRequest){
        return new ResponseEntity<>(adminService.addMovie(movieRequest.toMovie()).toMovieResponse(), HttpStatus.CREATED);
    }

}
