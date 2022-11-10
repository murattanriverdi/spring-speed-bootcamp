package com.murattanriverdi.inventory.business.service;

import com.murattanriverdi.inventory.business.dto.CategoryDto;
import com.murattanriverdi.inventory.business.dto.ProductDto;
import com.murattanriverdi.inventory.data.entity.Category;
import com.murattanriverdi.inventory.data.entity.Product;
import com.murattanriverdi.inventory.data.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getProductByCategoryId(long categoryId) {

        List<Product> products = productRepository.getProductByCategoryId(categoryId);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = entityToDto(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public ProductDto findById(long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            return null;
        }
        return entityToDto(productOpt.get());

    }

    private Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        if (null != productDto) {
            product.setProductId(productDto.getProductId());
            product.setProductName(productDto.getProductName());
        }
        return product;
    }

    private ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        if (null != product) {
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setSalesPrice(product.getSalesPrice());
            productDto.setCategoryDto(categoryEntityToDto(product.getCategory()));
        }
        return productDto;
    }

    private CategoryDto categoryEntityToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        if (null != category) {
            categoryDto.setCategoryId(category.getCategoryId());
            categoryDto.setCategoryName(category.getCategoryName());
        }
        return categoryDto;
    }
}
