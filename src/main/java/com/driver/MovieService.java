package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return "success message wrapped in a ResponseEntity object";
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "success message wrapped in a ResponseEntity object";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        movieRepository.addMovieDirectorPair(movieName, directorName);
        return "success message wrapped in a ResponseEntity object";
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }

    public ArrayList<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public ArrayList<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String directorName) {
        movieRepository.deleteDirectorByName(directorName);
        return "success message wrapped in a ResponseEntity object";
    }

    public String deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
        return "success message wrapped in a ResponseEntity object";
    }
}
