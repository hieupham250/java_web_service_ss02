package ra.edu.ss02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.edu.ss02.entity.Movie;
import ra.edu.ss02.service.MovieService;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String listMovies(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "movie/movie-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie/movie-add";
    }

    @PostMapping("/add")
    public String addMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movie);
        return "movie/movie-edit";
    }

    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable("id") Long id, @ModelAttribute("movie") Movie updatedMovie) {
        Movie existing = movieService.findById(id);
        if (existing != null) {
            existing.setTitle(updatedMovie.getTitle());
            existing.setGenre(updatedMovie.getGenre());
            existing.setDuration(updatedMovie.getDuration());
            movieService.update(existing);
        }
        return "redirect:/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.delete(id);
        return "redirect:/movies";
    }
}

