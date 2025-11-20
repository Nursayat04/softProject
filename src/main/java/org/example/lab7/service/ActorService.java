package org.example.lab7.service;

import org.example.lab7.dto.ActorDto;

import java.util.List;


public interface ActorService {
    List<ActorDto> getAll();
    ActorDto getById(Long id);
    ActorDto create(ActorDto dto);
    ActorDto update(Long id, ActorDto dto);
    void delete(Long id);
}
