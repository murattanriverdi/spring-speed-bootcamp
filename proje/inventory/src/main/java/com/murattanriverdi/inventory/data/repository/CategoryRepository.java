package com.murattanriverdi.inventory.data.repository;

import com.murattanriverdi.inventory.data.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
