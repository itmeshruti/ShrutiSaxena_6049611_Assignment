//package com.cg.demo.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.demo.entities.Movies;
//import com.cg.demo.repo.IMovie;
//
//@Service
//public class MovieService implements MovieInterface {
//
//	@Autowired
//	IMovie movieRepo;
//
//	@Override
//	public void addMovie(Movies movie) throws Exception {
//		movieRepo.save(movie);
//		System.out.println("Movie added successfully");
//
//	}
//
//	@Override
//	public void deleteMovie(String name) throws Exception {
//		Movies movie = movieRepo.findByName(name);
//
//		if (movie == null) {
//			throw new Exception("Movie not found");
//		}
//
//		movieRepo.delete(movie);
//		System.out.println("Movie deleted successfully");
//
//	}
//
//	@Override
//	public List<Movies> searchAllMovies() throws Exception {
//		List<Movies> list = movieRepo.findAll();
//		return list;
//	}
//
//	@Override
//	public List<Movies> searchByGenre(String genre) throws Exception {
//		return movieRepo.findByGenre(genre);
//	}
//
//	@Override
//	public void updateMovie(String name, double rating, String genre) throws Exception {
//
//		Movies movie = movieRepo.findByName(name);
//
//		if (movie == null) {
//			throw new Exception("Movie not found");
//		}
//
//		movie.setRating(rating);
//		movie.setGenre(genre);
//
//		movieRepo.save(movie);
//
//		System.out.println("Movie updated successfully");
//	}
//
//}



package com.cg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.entities.Movies;
import com.cg.demo.repo.IMovie;

@Service
public class MovieService implements MovieInterface {

    @Autowired
    IMovie movieRepo;
    @Override
    public void addMovie(Movies movie) throws Exception {

        Movies existing = movieRepo.findByName(movie.getName());

        // ✅ If adding new movie
        if (movie.getId() == 0) {
            if (existing != null) {
                throw new Exception("Movie already exists!");
            }
        }

        // ✅ If updating existing movie
        else {
            if (existing != null && existing.getId() != movie.getId()) {
                throw new Exception("Movie name already used by another movie!");
            }
        }

        movieRepo.save(movie);
    }

    @Override
    public void deleteMovie(int id) throws Exception {
        movieRepo.deleteById(id);
    }

    @Override
    public List<Movies> searchAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public List<Movies> searchByGenre(String genre) {
        return movieRepo.findByGenre(genre);
    }

    @Override
    public Movies getById(int id) {
        return movieRepo.findById(id).orElse(null);
    }

    @Override
    public void updateMovie(Movies movie) throws Exception {
        movieRepo.save(movie);
    }
}
