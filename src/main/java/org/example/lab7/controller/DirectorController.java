package org.example.lab7.controller;

import lombok.RequiredArgsConstructor;
import org.example.lab7.dto.DirectorDto;
import org.example.lab7.service.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService categoryService;

    @GetMapping
    public ResponseEntity<List<DirectorDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> getCategoryById(@PathVariable Long id) {
        DirectorDto dto = categoryService.getById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DirectorDto> createCategory(@RequestBody DirectorDto dto) {
        return ResponseEntity.ok(categoryService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorDto> updateCategory(@PathVariable Long id, @RequestBody DirectorDto dto) {
        DirectorDto updated = categoryService.update(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
