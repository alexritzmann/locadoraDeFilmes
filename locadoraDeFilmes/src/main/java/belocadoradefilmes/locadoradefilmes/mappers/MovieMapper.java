package belocadoradefilmes.locadoradefilmes.mappers;

import belocadoradefilmes.locadoradefilmes.dtos.requests.MovieRequestDto;
import belocadoradefilmes.locadoradefilmes.dtos.responses.MovieResponseDto;
import belocadoradefilmes.locadoradefilmes.entities.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieMapper
{
    public Movie toEntity(MovieRequestDto dto)
    {
        if (dto == null) return null;

        Movie entity = new Movie();
        entity.setTitle(dto.getTitle());
        entity.setGenre(dto.getGenre());
        entity.setYear(dto.getYear());
        entity.setRating(dto.getRating());
        return entity;
    }

    public MovieResponseDto toDto(Movie movie)
    {
        if (movie == null) return null;

        return MovieResponseDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .year(movie.getYear())
                .rating(movie.getRating())
                .build();
    }


    public List<MovieResponseDto> toDtos(List<Movie> movies)
    {
        return movies.stream().map(this::toDto).toList();
    }


    public void updateEntity(MovieRequestDto dto, Movie movie)
    {
        if (movie == null || dto == null) return;

        movie.setTitle(dto.getTitle());
        movie.setGenre(dto.getGenre());
        movie.setYear(dto.getYear());
        movie.setRating(dto.getRating());
    }


}
