//package com.cg.demo.service;
//
//
//import java.util.List;
//
//import com.cg.demo.entities.Movies;
//
//public interface MovieInterface {
//public void addMovie(Movies movie) throws Exception;
//public void deleteMovie(String name) throws Exception;
//public List<Movies> searchAllMovies() throws Exception;
//public List<Movies> searchByGenre(String genre) throws Exception;
//public void updateMovie(String name, double rating,String genre) throws Exception;
//
//
//}


package com.cg.demo.service;

import java.util.List;
import com.cg.demo.entities.Movies;

public interface MovieInterface {

    void addMovie(Movies movie) throws Exception;

    void deleteMovie(int id) throws Exception;

    List<Movies> searchAllMovies();

    List<Movies> searchByGenre(String genre);

    Movies getById(int id);

    void updateMovie(Movies movie) throws Exception;
}