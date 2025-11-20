package org.example.lab7.service;

import lombok.RequiredArgsConstructor;
import org.example.lab7.dto.CategoryDto;
import org.example.lab7.entity.Category;
import org.example.lab7.Mapper.CategoryMapper;
import org.example.lab7.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toDtoList(categories);
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            return categoryMapper.toDto(category);
        }
        return null;
    }

    @Override
    public CategoryDto create(CategoryDto dto) {
        Category category = categoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toDto(saved);
    }

    @Override
    public CategoryDto update(Long id, CategoryDto dto) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null) return null;

        category.setName(dto.getName());

        Category updated = categoryRepository.save(category);
        return categoryMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
