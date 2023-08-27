package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        return ResponseEntity.ok(movieService.addDirector(director));
    }
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName, @RequestParam("director") String directorName) {
        return ResponseEntity.ok(movieService.addMovieDirectorPair(movieName, directorName));
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(movieService.getMovieByName(name));
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(movieService.getDirectorByName(name));
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<ArrayList<String>> getMoviesByDirectorName(@PathVariable("director") String directorName) {
        return ResponseEntity.ok((ArrayList<String>) movieService.getMoviesByDirectorName(directorName));
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @PutMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName") String directorName) {
        return ResponseEntity.ok(movieService.deleteDirectorByName(directorName));
    }

    public ResponseEntity<String> deleteAllDirectors() {
        return ResponseEntity.ok(movieService.deleteAllDirectors());
    }
}
