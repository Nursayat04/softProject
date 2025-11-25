package org.example.lab7.service;

import lombok.RequiredArgsConstructor;
import org.example.lab7.dto.ActorDto;
import org.example.lab7.dto.MovieDto;
import org.example.lab7.entity.Actor;
import org.example.lab7.entity.Director;
import org.example.lab7.entity.Movie;
import org.example.lab7.repository.ActorRepository;
import org.example.lab7.repository.DirectorRepository;
import org.example.lab7.repository.MovieRepository;
import org.example.lab7.Mapper.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MovieServiceImplementation implements MovieService {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final MovieMapper movieMapper;

    @Override
    public List<MovieDto> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return movieMapper.toDtoList(movies);
    }

    @Override
    public MovieDto getById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            return movieMapper.toDto(movie);
        }
        return null;
    }

    @Override
    public MovieDto create(MovieDto dto) {
        Movie movie = movieMapper.toEntity(dto);

        if (dto.getDirector() != null && dto.getDirector().getId() != null) {
            Director category = directorRepository.findById(dto.getDirector().getId()).orElse(null);
            movie.setDirector(category);
        }

        List<Actor> actors = new ArrayList<>();
        if (dto.getActors() != null) {
            for (ActorDto actorDto : dto.getActors()) {
                if (actorDto.getId() != null) {
                    Actor actor = actorRepository.findById(actorDto.getId()).orElse(null);
                    if (actor != null) {
                        actors.add(actor);
                    }
                }
            }
        }
        movie.setActors(actors);

        Movie savedMovie = movieRepository.save(movie);
        return movieMapper.toDto(savedMovie);
    }


    @Override
    public MovieDto update(Long id, MovieDto dto) {
        Movie existingMovie = movieRepository.findById(id).orElse(null);

        if (existingMovie != null) {
            existingMovie.setTitle(dto.getTitle());
            existingMovie.setGenre(dto.getGenre());
            existingMovie.setReleaseYear(dto.getReleaseYear());
            existingMovie.setRating(dto.getRating());

            if (dto.getDirector() != null && dto.getDirector().getId() != null) {
                Director category = directorRepository.findById(dto.getDirector().getId()).orElse(null);
                existingMovie.setDirector(category);
            } else {
                existingMovie.setDirector(null);
            }

            List<Actor> actors = new ArrayList<>();
            if (dto.getActors() != null) {
                for (ActorDto actorDto : dto.getActors()) {
                    if (actorDto.getId() != null) {
                        Actor actor = actorRepository.findById(actorDto.getId()).orElse(null);
                        if (actor != null) {
                            actors.add(actor);
                        }
                    }
                }
            }
            existingMovie.setActors(actors);

            Movie updatedMovie = movieRepository.save(existingMovie);
            return movieMapper.toDto(updatedMovie);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
