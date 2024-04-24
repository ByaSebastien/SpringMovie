package be.bstorm.springmovie.api.forms;

import be.bstorm.springmovie.domain.entities.Movie;

import java.time.LocalDate;

public record MovieForm(
        String title,
        String description,
        LocalDate releaseDate,
        String type
) {
    public Movie toEntity(){
        return new Movie(title, description, releaseDate, type);
    }
}
