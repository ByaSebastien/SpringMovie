package be.bstorm.springmovie.bll.services.impls;

import be.bstorm.springmovie.bll.services.MovieService;
import be.bstorm.springmovie.dal.repositories.MovieRepository;
import be.bstorm.springmovie.domain.entities.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Long create(Movie movie) {
        return movieRepository.save(movie).getId();
    }

    @Override
    public Movie getById(Long id) {
        return movieRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public void update(Long id, Movie movie) {
        Movie movieToUpdate = movieRepository.findById(id).orElseThrow();
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDescription(movieToUpdate.getDescription());
        movieToUpdate.setReleaseDate(movieToUpdate.getReleaseDate());
        movieToUpdate.setType(movieToUpdate.getType());
        movieRepository.save(movieToUpdate);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
