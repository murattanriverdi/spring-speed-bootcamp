package com.murattanriverdi.orm.presentation.rest;

import com.murattanriverdi.orm.business.dto.ProductDto;
import com.murattanriverdi.orm.business.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {

    private ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

        /*
    @GetMapping("/api/product")
    public Product getProduct(){
        return new Product(301,"Samsung Cep Telefonu",1450);
    }
     */

    @GetMapping("/api/product/{id}")
    public ProductDto getProduct(@PathVariable("id") long productId) {
        return productService.find(productId);
    }

    @GetMapping("/api/products")
    public List<ProductDto> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/api/product")
    public ProductDto postProduct(@RequestBody ProductDto productDto) {
        long productId = productService.create(productDto);
        productDto.setProductId(productId);
        return productDto;
    }

    @PutMapping("/api/product")
    public String putProduct(@RequestBody ProductDto productDto) {
        productService.update(productDto);
        return "Güncellendi";
    }

    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(@PathVariable("id") long productId) {
        productService.delete(productId);
    }








}
