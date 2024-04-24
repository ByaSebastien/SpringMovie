package be.bstorm.springmovie.api.controllers;

import be.bstorm.springmovie.api.dtos.MovieDetailDTO;
import be.bstorm.springmovie.api.dtos.MovieSimpleDTO;
import be.bstorm.springmovie.api.forms.MovieForm;
import be.bstorm.springmovie.bll.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Void> addMovie(@RequestBody MovieForm movie) {

        Long id = movieService.create(movie.toEntity());
        UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id);
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping
    public ResponseEntity<List<MovieSimpleDTO>> getMovies() {
        List<MovieSimpleDTO> movies = movieService.getAll().stream().map(MovieSimpleDTO::fromEntity).toList();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailDTO> getMovie(@PathVariable Long id) {
        MovieDetailDTO movie = MovieDetailDTO.fromEntity(movieService.getById(id));
        return ResponseEntity.ok(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMovie(@PathVariable Long id, @RequestBody MovieForm movie) {
        movieService.update(id, movie.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
