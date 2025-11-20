package org.example.lab7.service;

import lombok.RequiredArgsConstructor;
import org.example.lab7.dto.ActorDto;
import org.example.lab7.entity.Actor;
import org.example.lab7.Mapper.ActorMapper;
import org.example.lab7.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImplementation implements ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    @Override
    public List<ActorDto> getAll() {
        List<Actor> actors = actorRepository.findAll();
        return actorMapper.toDtoList(actors);
    }

    @Override
    public ActorDto getById(Long id) {
        Actor actor = actorRepository.findById(id).orElse(null);
        if (actor != null) {
            return actorMapper.toDto(actor);
        }
        return null;
    }

    @Override
    public ActorDto create(ActorDto dto) {
        Actor actor = actorMapper.toEntity(dto);
        Actor saved = actorRepository.save(actor);
        return actorMapper.toDto(saved);
    }

    @Override
    public ActorDto update(Long id, ActorDto dto) {
        Actor actor = actorRepository.findById(id).orElse(null);
        if (actor == null) return null;

        actor.setFullName(dto.getFullName());

        Actor updated = actorRepository.save(actor);
        return actorMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        actorRepository.deleteById(id);
    }
}
