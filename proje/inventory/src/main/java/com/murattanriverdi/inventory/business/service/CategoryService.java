package com.murattanriverdi.inventory.business.service;

import com.murattanriverdi.inventory.business.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();
}
