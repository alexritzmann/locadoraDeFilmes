package belocadoradefilmes.locadoradefilmes.services;

import belocadoradefilmes.locadoradefilmes.dtos.requests.MovieRequestDto;
import belocadoradefilmes.locadoradefilmes.dtos.responses.MovieResponseDto;

import java.util.List;

public interface MovieService
{
    List<MovieResponseDto> findAll();
    MovieResponseDto findById(Long id);
    MovieResponseDto create(MovieRequestDto dto);
    MovieResponseDto update(MovieRequestDto dto, Long id);
    void delete(Long id);
}
