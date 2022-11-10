package com.murattanriverdi.inventory.business.service;

import com.murattanriverdi.inventory.business.dto.CategoryDto;
import com.murattanriverdi.inventory.data.entity.Category;
import com.murattanriverdi.inventory.data.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<CategoryDto> findAll() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        Iterable<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            CategoryDto categoryDto = entityToDto(category);
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }


    private Category dtoToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        if (null != categoryDto) {
            category.setCategoryId(categoryDto.getCategoryId());
            category.setCategoryName(categoryDto.getCategoryName());
        }
        return category;
    }

    private CategoryDto entityToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        if (null != category) {
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategoryName(category.getCategoryName());
        }
        return categoryDto;
    }
}
