package belocadoradefilmes.locadoradefilmes.services;

import belocadoradefilmes.locadoradefilmes.dtos.requests.MovieRequestDto;
import belocadoradefilmes.locadoradefilmes.dtos.responses.MovieResponseDto;
import belocadoradefilmes.locadoradefilmes.entities.Movie;
import belocadoradefilmes.locadoradefilmes.mappers.MovieMapper;
import belocadoradefilmes.locadoradefilmes.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService
{
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieResponseDto> findAll()
    {
        return movieMapper.toDtos(movieRepository.findAll());
    }

    @Override
    public MovieResponseDto findById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieResponseDto create(MovieRequestDto dto) {
        Movie movie = movieMapper.toEntity(dto);
        return movieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public MovieResponseDto update(MovieRequestDto dto, Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        movieMapper.updateEntity(dto, movie);
        assert movie != null;
        return movieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}

