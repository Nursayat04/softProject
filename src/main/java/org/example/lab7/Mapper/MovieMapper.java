package org.example.lab7.Mapper;

import org.example.lab7.dto.MovieDto;
import org.example.lab7.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, ActorMapper.class})
public interface MovieMapper {

    MovieDto toDto(Movie entity);

    Movie toEntity(MovieDto dto);

    List<MovieDto> toDtoList(List<Movie> entities);
}

