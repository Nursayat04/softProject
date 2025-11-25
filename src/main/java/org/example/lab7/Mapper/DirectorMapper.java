package org.example.lab7.Mapper;

import org.example.lab7.dto.DirectorDto;
import org.example.lab7.entity.Director;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    DirectorDto toDto(Director entity);

    Director toEntity(DirectorDto dto);

    List<DirectorDto> toDtoList(List<Director> directors);
}
