package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.Key;
import java.util.*;

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

    public List<String> getMoviesByDirectorName(String name) {
        List<String>movies=new ArrayList<>();
        for(String movie: dbMD.keySet()){
            if(dbMD.get(movie).equals(name)){
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(dbM.keySet());
    }

    public void deleteDirectorByName(String name) {
        if(dbD.containsKey(name)){
            dbD.remove((name));
        }
        for(String movie:dbMD.keySet()){
            if(dbMD.get(movie).equals(name)){
                dbM.remove(movie);
            }
        }
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
