package com.murattanriverdi.rest.service;

import com.murattanriverdi.rest.Product;

import java.util.List;

public interface ProductService {

    Product find(long productId);

    List<Product> findAll();

    Product createProduct(Product product);

    void putProduct(Product product);

    void deleteProduct(long id);
}
