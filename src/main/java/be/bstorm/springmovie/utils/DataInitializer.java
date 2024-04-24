package be.bstorm.springmovie.utils;

import be.bstorm.springmovie.dal.repositories.MovieRepository;
import be.bstorm.springmovie.domain.entities.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Movie> movies = new ArrayList<>();

        // Ajout des films à la liste
        movies.add(new Movie("Amélie", "Une jeune femme cherche à rendre le monde meilleur autour d'elle à Paris.", LocalDate.of(2001, 4, 25), "Comédie romantique"));
        movies.add(new Movie("La Haine", "Trois jeunes vivant dans les banlieues françaises font face à la brutalité policière.", LocalDate.of(1995, 5, 31), "Drame"));
        movies.add(new Movie("Le Fabuleux Destin d'Amélie Poulain", "Amélie découvre un sens nouveau à sa vie en rendant le bonheur aux autres.", LocalDate.of(2001, 4, 25), "Comédie romantique"));
        movies.add(new Movie("Intouchables", "Un aristocrate tétraplégique engage un homme de banlieue comme aide-soignant.", LocalDate.of(2011, 11, 2), "Comédie dramatique"));
        movies.add(new Movie("La Vie d'Adèle", "Adele's life is changed when she meets Emma, a young woman with blue hair.", LocalDate.of(2013, 10, 23), "Drame romantique"));
        movies.add(new Movie("Les Choristes", "A music teacher changes the lives of troubled children through music.", LocalDate.of(2004, 3, 17), "Drame musical"));
        movies.add(new Movie("Le Dîner de Cons", "A wealthy publisher bets with his friends to find the biggest idiot at a weekly dinner.", LocalDate.of(1998, 4, 15), "Comédie"));
        movies.add(new Movie("Les Misérables", "A cop from the provinces moves to Paris to join the Anti-Crime Brigade.", LocalDate.of(2019, 11, 20), "Drame policier"));
        movies.add(new Movie("Léon: The Professional", "A hitman named Léon takes in Mathilda, a 12-year-old girl, after her family is killed.", LocalDate.of(1994, 9, 14), "Action, thriller"));
        movies.add(new Movie("La Môme", "The life of Édith Piaf, a French singer who became one of the country's most famous performers.", LocalDate.of(2007, 2, 8), "Biographie, drame"));

        for(Movie movie : movies) {
            movieRepository.save(movie);
        }
    }
}
