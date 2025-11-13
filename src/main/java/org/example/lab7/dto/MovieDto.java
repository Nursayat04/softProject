package org.example.lab7.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieDto {
    private Long id;
    private String title;
    private String genre;
    private int releaseYear;
    private double rating;
}
