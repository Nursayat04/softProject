package org.example.lab7.service;

import org.example.lab7.dto.MovieDto;
import org.example.lab7.entity.Movie;
import org.example.lab7.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImplementation implements MovieService{
    private final MovieRepository repository;

    public MovieServiceImplementation(MovieRepository repository) {
        this.repository = repository;
    }

    private MovieDto toDto(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .releaseYear(movie.getReleaseYear())
                .rating(movie.getRating())
                .build();

    }

    private Movie toEntity(MovieDto dto) {
            Movie mv = new Movie();
            mv.setId(dto.getId());
            mv.setTitle(dto.getTitle());
            mv.setGenre(dto.getGenre());
            mv.setReleaseYear(dto.getReleaseYear());
            mv.setRating(dto.getRating());
            return mv;
    }

    public List<MovieDto> getAll() {
        List<Movie> movies = repository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : movies) {
            movieDtos.add(toDto(movie));
        }
        return movieDtos;
    }

    public MovieDto getById(Long id) {
        Movie movie = repository.findById(id).orElse(null);
        if(movie != null){
            return toDto(movie);
        }
        return null;
    }

    public MovieDto create(MovieDto dto) {
        Movie saved = repository.save(toEntity(dto));
        return toDto(saved);
    }

    public MovieDto update(Long id, MovieDto dto) {
        Movie updateMovie = repository.findById(id).orElse(null);
        if( updateMovie == null){
            return null;
        }
        updateMovie.setTitle(dto.getTitle());
        updateMovie.setGenre(dto.getGenre());
        updateMovie.setReleaseYear(dto.getReleaseYear());
        updateMovie.setRating(dto.getRating());

        Movie updated = repository.save(updateMovie);
        return toDto(updated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
