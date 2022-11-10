package com.murattanriverdi.orm.data.repository;

import com.murattanriverdi.orm.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product as p where p.salesPrice >= :minPrice")
    List<Product> findAllBySalesPriceMin(@Param("minPrice") double minPrice);

}
