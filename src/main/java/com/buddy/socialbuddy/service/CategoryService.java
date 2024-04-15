package com.buddy.socialbuddy.service;

import com.buddy.socialbuddy.controller.dto.CategoryDto;
import com.buddy.socialbuddy.domain.Category;
import com.buddy.socialbuddy.mapper.CategoryMapper;
import com.buddy.socialbuddy.repository.CategoryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final CategoryMapper categoryMapper;

  public Category findById(String categoryId) {
    return categoryRepository.findByIdOrThrow(categoryId);
  }

  public List<CategoryDto> getAllCategories() {
    return categoryMapper.toDtos(categoryRepository.findAll());
  }
}
