package com.murattanriverdi.rest.resource;


import com.murattanriverdi.rest.Product;
import com.murattanriverdi.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    /*
    @GetMapping("/api/product")
    public Product getProduct(){
        return new Product(301,"Samsung Cep Telefonu",1450);
    }
     */

    @GetMapping("/api/product/{id}")
    public Product getProduct(@PathVariable("id") long productId) {
        return productService.find(productId);
    }

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("/api/product")
    public Product postProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/api/product")
    public String putProduct(@RequestBody Product product) {
        productService.putProduct(product);
        return "Güncellendi";
    }

    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(@PathVariable("id") long productId) {
        productService.deleteProduct(productId);
    }


}
