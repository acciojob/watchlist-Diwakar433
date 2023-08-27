package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director) {
        return movieService.addDirector(director);
    }
    @PostMapping("/add-movie-director-pair")
    public String addMovieDirectorPair(@RequestParam("movie") String movieName, @RequestParam("director") String directorName) {
        return movieService.addMovieDirectorPair(movieName, directorName);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public Movie getMovieByName(@PathVariable("name") String name) {
        return movieService.getMovieByName(name);
    }

    @GetMapping("/get-director-by-name/{name}")
    public Director getDirectorByName(@PathVariable("name") String name) {
        return movieService.getDirectorByName(name);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ArrayList<String> getMoviesByDirectorName(@PathVariable("director") String directorName) {
        return movieService.getMoviesByDirectorName(directorName);
    }

    @GetMapping("/get-all-movies")
    public ArrayList<String> findAllMovies() {
        return movieService.findAllMovies();
    }

    @PutMapping("/delete-director-by-name")
    public String deleteDirectorByName(@RequestParam("directorName") String directorName) {
        return movieService.deleteDirectorByName(directorName);
    }

    public String deleteAllDirectors() {
        return movieService.deleteAllDirectors();
    }
}
