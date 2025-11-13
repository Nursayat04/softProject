package org.example.lab7.controller;

import lombok.RequiredArgsConstructor;
import org.example.lab7.dto.MovieDto;
import org.example.lab7.service.MovieService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService service;


    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        List<MovieDto> movies = service.getAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable Long id) {
        MovieDto movie = service.getById(id);
        return new ResponseEntity<>(movie, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MovieDto> create(@RequestBody MovieDto dto) {
        MovieDto createdMovie = service.create(dto);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody MovieDto dto) {
        MovieDto updatedMovie = service.update(id, dto);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}