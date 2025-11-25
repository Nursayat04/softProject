package org.example.lab7.controller;

import lombok.RequiredArgsConstructor;
import org.example.lab7.dto.DirectorDto;
import org.example.lab7.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<DirectorDto>> getAllDirectors() {
        return ResponseEntity.ok(directorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> getDirectorById(@PathVariable Long id) {
        DirectorDto dto = directorService.getById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DirectorDto> createDirector(@RequestBody DirectorDto dto) {
        return ResponseEntity.ok(directorService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorDto> updateDirector(@PathVariable Long id, @RequestBody DirectorDto dto) {
        DirectorDto updated = directorService.update(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        directorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
