//
//
//package com.cg.demo.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.cg.demo.service.MovieService;
//import com.cg.demo.entities.Movies;
//
//@Controller
//public class MyController {
//
//    @Autowired
//    MovieService mService;
//
//    @RequestMapping("/greet")
//    public ModelAndView processGreet() {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("msg", "Welcome to Movie App");
//        mv.setViewName("welcome");
//        return mv;
//    }
//
//   
//  
//    
//    @GetMapping("/movies")
//    public ModelAndView showMovies() throws Exception {
//
//        ModelAndView mv = new ModelAndView("movies");
//
//        // empty object for form binding (IMPORTANT)
//        mv.addObject("movie", new Movies());
//
//        // list of movies for table
//        List<Movies> moviesList = mService.searchAllMovies();
//        mv.addObject("movies", moviesList);
//
//        return mv;
//    }
//
//    // ✅ Handle form submission
//    @PostMapping("/addMovie")
//    public ModelAndView addMovie(@ModelAttribute Movies movie) throws Exception {
//
//        mService.addMovie(movie);
//
//        // redirect to avoid duplicate form submission
//        return new ModelAndView("redirect:/movies");
//    }
//    
//}




//package com.cg.demo.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.validation.Valid;
//
//import com.cg.demo.entities.Movies;
//import com.cg.demo.service.MovieService;
//
//@Controller
//public class MyController {
//
//    @Autowired
//    MovieService mService;
//
//    // 🔹 SHOW PAGE
//    @GetMapping("/movies")
//    public String showMovies(Model model) {
//
//        model.addAttribute("movie", new Movies());
//        model.addAttribute("movies", mService.searchAllMovies());
//
//        return "movies";
//    }
//
//    // 🔹 ADD / UPDATE MOVIE
//    @PostMapping("/addMovie")
//    public String addMovie(
//            @Valid @ModelAttribute("movie") Movies movie,
//            BindingResult result,
//            Model model) {
//
//        if (result.hasErrors()) {
//            model.addAttribute("movies", mService.searchAllMovies());
//            return "movies";
//        }
//
//        try {
//            mService.addMovie(movie); // works for both add + update
//        } catch (Exception e) {
//            model.addAttribute("errorMsg", e.getMessage());
//            model.addAttribute("movies", mService.searchAllMovies());
//            return "movies";
//        }
//
//        return "redirect:/movies";
//    }
//
//    // 🔹 DELETE
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable int id) throws Exception {
//        mService.deleteMovie(id);
//        return "redirect:/movies";
//    }
//
//    // 🔹 EDIT (LOAD DATA INTO FORM)
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable int id, Model model) {
//
//        model.addAttribute("movie", mService.getById(id));
//        model.addAttribute("movies", mService.searchAllMovies());
//
//        return "movies";
//    }
//
//    // 🔥 SEARCH BY GENRE
//    @PostMapping("/search")
//    public String search(@RequestParam("genre") String genre, Model model) {
//
//        List<Movies> list;
//
//        if (genre == null || genre.isBlank()) {
//            list = mService.searchAllMovies();
//        } else {
//            list = mService.searchByGenre(genre);
//        }
//
//        model.addAttribute("movie", new Movies());
//        model.addAttribute("movies", list);
//
//        if (list.isEmpty()) {
//            model.addAttribute("msg", "No movies found for selected genre");
//        }
//
//        return "movies";
//    }
//
//    // 🔹 Prevent GET error
//    @GetMapping("/search")
//    public String redirectSearch() {
//        return "redirect:/movies";
//    }
//}


package com.cg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import com.cg.demo.entities.Movies;
import com.cg.demo.service.MovieService;

@Controller
public class MyController {

    @Autowired
    MovieService mService;

    // 🔹 HOME - SHOW ALL MOVIES
    @GetMapping("/movies")
    public String showMovies(Model model) {
        model.addAttribute("movies", mService.searchAllMovies());
        return "movies";
    }

    // 🔹 OPEN ADD PAGE
    @GetMapping("/add")
    public String showAddPage(Model model) {
        model.addAttribute("movie", new Movies());
        return "addMovie";
    }

    // 🔹 SAVE MOVIE (ADD + UPDATE)
    @PostMapping("/save")
    public String saveMovie(
            @Valid @ModelAttribute("movie") Movies movie,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "addMovie";
        }

        try {
            mService.addMovie(movie);
        } catch (Exception e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "addMovie";
        }

        return "redirect:/movies";
    }

    // 🔹 EDIT
    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable int id, Model model) {
        model.addAttribute("movie", mService.getById(id));
        return "addMovie";
    }

    // 🔹 DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) throws Exception {
        mService.deleteMovie(id);
        return "redirect:/movies";
    }

    // 🔹 SEARCH PAGE
    @GetMapping("/search")
    public String searchPage() {
        return "search";
    }

    // 🔹 SEARCH RESULT
    @PostMapping("/search")
    public String searchResult(@RequestParam String genre, Model model) {

        List<Movies> list;

        if (genre == null || genre.isBlank()) {
            list = mService.searchAllMovies();
        } else {
            list = mService.searchByGenre(genre);
        }

        model.addAttribute("movies", list);

        if (list.isEmpty()) {
            model.addAttribute("msg", "No movies found!");
        }

        return "search";
    }
}