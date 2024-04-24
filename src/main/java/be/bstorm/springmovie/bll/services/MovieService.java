package be.bstorm.springmovie.bll.services;


import be.bstorm.springmovie.domain.entities.Movie;

import java.util.List;

public interface MovieService {

    Long create(Movie movie);
    Movie getById(Long id);
    List<Movie> getAll();
    void update(Long id, Movie movie);
    void delete(Long id);
}
