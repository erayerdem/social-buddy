package com.buddy.socialbuddy.controller;

import com.buddy.socialbuddy.base.dto.ApiResponse;
import com.buddy.socialbuddy.controller.dto.CategoryDto;
import com.buddy.socialbuddy.mapper.CategoryMapper;
import com.buddy.socialbuddy.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("categories")
public class CategoryController {

  private final CategoryService categoryService;
  private final CategoryMapper categoryMapper;

  @GetMapping
  public ApiResponse<List<CategoryDto>> getAllCategories() {

    List<CategoryDto> categories = categoryService.getAllCategories();
    return ApiResponse.<List<CategoryDto>>builder().data(categories).build();
  }

  @GetMapping("{id}")
  public ApiResponse<CategoryDto> findById(@PathVariable("id") String id) {

    CategoryDto category = categoryMapper.toDto(categoryService.findById(id));

    return ApiResponse.<CategoryDto>builder().data(category).build();
  }
}
