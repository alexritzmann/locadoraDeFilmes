package belocadoradefilmes.locadoradefilmes.controllers;

import belocadoradefilmes.locadoradefilmes.dtos.requests.MovieRequestDto;
import belocadoradefilmes.locadoradefilmes.dtos.responses.MovieResponseDto;
import belocadoradefilmes.locadoradefilmes.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController
{

    private final MovieService movieService;

    @GetMapping
    public List<MovieResponseDto> findAll()
    {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieResponseDto findById(@PathVariable Long id)
    {
        return movieService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto create(@RequestBody MovieRequestDto dto)
    {
        return movieService.create(dto);
    }

    @PutMapping("/{id}")
    public MovieResponseDto update(@PathVariable Long id, @RequestBody MovieRequestDto dto)
    {
        return movieService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id)
    {
        movieService.delete(id);
    }


}