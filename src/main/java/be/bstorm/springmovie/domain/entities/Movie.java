package be.bstorm.springmovie.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = true, length = 255)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate releaseDate;

    @Column(nullable = false)
    private String type;

    public Movie(String title, String description, LocalDate releaseDate, String type) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.type = type;
    }
}
