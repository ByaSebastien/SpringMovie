package be.bstorm.springmovie.api.dtos;

import be.bstorm.springmovie.domain.entities.Movie;

import java.time.LocalDate;

public record MovieDetailDTO(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        String type
) {

    public static MovieDetailDTO fromEntity(Movie movie){
        return new MovieDetailDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getReleaseDate(), movie.getType());
    }
}
