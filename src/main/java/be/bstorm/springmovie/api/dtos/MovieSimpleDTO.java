package be.bstorm.springmovie.api.dtos;

import be.bstorm.springmovie.domain.entities.Movie;

import java.time.LocalDate;

public record MovieSimpleDTO(
        Long id,
        String title,
        LocalDate releaseDate,
        String type
) {
    public static MovieSimpleDTO fromEntity(Movie movie) {
        return new MovieSimpleDTO(movie.getId(), movie.getTitle(), movie.getReleaseDate(), movie.getType());
    }
}
