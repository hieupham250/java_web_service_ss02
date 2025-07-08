package ra.edu.ss02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ss02.entity.Movie;
import ra.edu.ss02.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService implements IService<Movie, Long> {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie update(Movie movie) {
        if (movie.getId() != null && movieRepository.existsById(movie.getId())) {
            return movieRepository.save(movie);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}

