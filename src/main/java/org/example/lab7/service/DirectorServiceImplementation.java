package org.example.lab7.service;

import lombok.RequiredArgsConstructor;
import org.example.lab7.dto.DirectorDto;
import org.example.lab7.entity.Director;
import org.example.lab7.Mapper.DirectorMapper;
import org.example.lab7.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImplementation implements DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper categoryMapper;

    @Override
    public List<DirectorDto> getAll() {
        List<Director> categories = directorRepository.findAll();
        return categoryMapper.toDtoList(categories);
    }

    @Override
    public DirectorDto getById(Long id) {
        Director category = directorRepository.findById(id).orElse(null);
        if (category != null) {
            return categoryMapper.toDto(category);
        }
        return null;
    }

    @Override
    public DirectorDto create(DirectorDto dto) {
        Director category = categoryMapper.toEntity(dto);
        Director saved = directorRepository.save(category);
        return categoryMapper.toDto(saved);
    }

    @Override
    public DirectorDto update(Long id, DirectorDto dto) {
        Director category = directorRepository.findById(id).orElse(null);
        if (category == null) return null;

        category.setName(dto.getName());

        Director updated = directorRepository.save(category);
        return categoryMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        directorRepository.deleteById(id);
    }
}
