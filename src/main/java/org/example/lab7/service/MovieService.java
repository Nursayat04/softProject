package org.example.lab7.service;

import org.example.lab7.dto.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> getAll();

    MovieDto getById(Long id);

    MovieDto create(MovieDto dto);

    MovieDto update(Long id, MovieDto dto);

    void delete(Long id);
}
