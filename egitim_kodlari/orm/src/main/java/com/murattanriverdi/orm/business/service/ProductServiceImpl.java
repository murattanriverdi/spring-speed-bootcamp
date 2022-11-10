package com.murattanriverdi.orm.business.service;

import com.murattanriverdi.orm.business.dto.ProductDto;
import com.murattanriverdi.orm.data.entity.Product;
import com.murattanriverdi.orm.data.repository.ProductRepository;
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
    public long create(ProductDto productDto) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public void update(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setSalesPrice(productDto.getSalesPrice());
        productRepository.save(product);
    }

    @Override
    public ProductDto find(long productId) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if(productOpt.isPresent()){
            Product product = productOpt.get();
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setSalesPrice(product.getSalesPrice());
            return  productDto;
        }
        return null;
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        for(Product product : products){
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setSalesPrice(product.getSalesPrice());
            productDtos.add(productDto);
        }
        return productDtos;
    }

    @Override
    public void delete(long productId) {
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
        }
    }

    private Product toEntity(ProductDto dto){
        return null;
    }


    private ProductDto toDto(Product product){
        return null;
    }
}
