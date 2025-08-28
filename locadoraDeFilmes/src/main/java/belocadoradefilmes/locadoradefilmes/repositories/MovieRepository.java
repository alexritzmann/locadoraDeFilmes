package belocadoradefilmes.locadoradefilmes.repositories;

import belocadoradefilmes.locadoradefilmes.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>
{
    List<Movie> findByTitleContains(String title);

    List<Movie> findByGenre(String genre);

    List<Movie> findByYear(int year);

    List<Movie> findByRating(int rating);

    List<Movie> findByGenreAndYear(String genre, int year);

    boolean existsTitleAndGenreAndYearAndRating(String title, String genre, int year, int rating);

}

