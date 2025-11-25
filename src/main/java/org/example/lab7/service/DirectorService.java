package org.example.lab7.service;

import org.example.lab7.dto.DirectorDto;

import java.util.List;

public interface DirectorService {
    List<DirectorDto> getAll();
    DirectorDto getById(Long id);
    DirectorDto create(DirectorDto dto);
    DirectorDto update(Long id, DirectorDto dto);
    void delete(Long id);
}
