package com.murattanriverdi.inventory.data.repository;

import com.murattanriverdi.inventory.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p where p.category.categoryId = :categoryId")
    public List<Product> getProductByCategoryId(@Param("categoryId") long categoryId);
}
