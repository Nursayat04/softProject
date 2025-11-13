package org.example.lab7.repository;

import org.example.lab7.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository <Movie , Long> {

}
