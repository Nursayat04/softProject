package org.example.lab7.Mapper;

import org.example.lab7.dto.ActorDto;
import org.example.lab7.entity.Actor;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    ActorDto toDto(Actor entity);

    Actor toEntity(ActorDto dto);

    List<ActorDto> toDtoList(List<Actor> entities);

    List<Actor> toEntityList(List<ActorDto> dtos);
}
