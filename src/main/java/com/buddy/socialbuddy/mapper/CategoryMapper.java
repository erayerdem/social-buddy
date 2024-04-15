package com.buddy.socialbuddy.mapper;

import com.buddy.socialbuddy.base.BaseMapper;
import com.buddy.socialbuddy.controller.dto.CategoryDto;
import com.buddy.socialbuddy.domain.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {
}
