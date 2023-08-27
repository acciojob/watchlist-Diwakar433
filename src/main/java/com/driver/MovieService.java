package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return "movie added successfully";
    }


    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "director added successfully";
    }

    public String  addMovieDirectorPair(String movie, String director) {
        movieRepository.addMovieDirectorPair(movie,director);
        return "movie director paired successfully";
    }

    public Movie getMovieByName(String name) {
        return movieRepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movieRepository.getDirectorByName(name);
    }


    public List<String> getMoviesByDirectorName(String name) {
        return movieRepository.getMoviesByDirectorName(name);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
        return "director deleted successfully";
    }

    public String deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
        return "all directors deleted successfully";
    }
}