package org.example.lab7.entity;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.*;

@Entity
@Table(name = "movie")
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "genre", length = 100)
    private String genre;

    @Column(name = "releaseYear")
    private int releaseYear;

    @Column(name = "rating")
    private double rating;

}
