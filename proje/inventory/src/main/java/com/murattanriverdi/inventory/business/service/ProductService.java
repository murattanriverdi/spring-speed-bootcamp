package com.murattanriverdi.inventory.business.service;

import com.murattanriverdi.inventory.business.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProductByCategoryId(long categoryId);

    ProductDto findById(long productId);
}
