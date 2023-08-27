package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class MovieRepository {


    HashMap<String, Movie> dbM = new HashMap<>();
    HashMap<String, Director> dbD = new HashMap<>();
    HashMap<String, String> dbMD = new HashMap<>();
    public void addMovie(Movie movie) {
        dbM.put(movie.getName(), movie);
        return;
    }

    public void addDirector(Director director) {
        dbD.put(director.getName(), director);
        return;
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        dbMD.put(movieName, directorName);
        return;
    }

    public Movie getMovieByName(String name) {
        return dbM.get(name);
    }

    public Director getDirectorByName(String name) {
        return dbD.get(name);
    }

    private final ArrayList<String> MovieListByDirector = new ArrayList<>();
    public ArrayList<String> getMoviesByDirectorName(String directorName) {
        for(Map.Entry<String, String> entry : dbMD.entrySet()) {
            // if give value is equal to value from entry
            // print the corresponding key
            if (Objects.equals(entry.getValue(), directorName)) {
                MovieListByDirector.add(entry.getKey());
            }
        }
        return MovieListByDirector;
    }

    private final ArrayList<String> MoviesList = new ArrayList<>();
    public ArrayList<String> findAllMovies() {
        for(Map.Entry<String, Movie> entry : dbM.entrySet()) {
            MoviesList.add(entry.getKey());
        }
        return MoviesList;
    }

    public void deleteDirectorByName(String directorName) {
        dbMD.remove(directorName);
        return;
    }

    public void deleteAllDirectors() {
        for(String name:dbD.keySet()){
            for(String movie:dbMD.keySet()){
                if(dbMD.get(movie).equals(name)){
                    dbM.remove(movie);
                }
            }
        }
        dbD.clear();
    }
}
