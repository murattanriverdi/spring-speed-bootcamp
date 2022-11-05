package com.murattanriverdi.rest.service;

import com.murattanriverdi.rest.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product find(long productId) {
        Product product = new Product(productId,"Samsung Cep Telefonu",1450);
        System.out.println("işgörü çalıştı");
        return  product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(301,"Cep Telefonu",1450));
        productList.add(new Product(302,"Laptop",9832));
        productList.add(new Product(303,"Desktop",7634));
        return  productList;
    }

    @Override
    public Product createProduct(Product product) {
        product.setProductId(301);
        System.out.println("Ürün eklendi : "+product.getProductId() +" , "+product.getProductName()+" , "+product.getSalesPrice());
        return product;
    }

    @Override
    public void putProduct(Product product) {
        System.out.println("Ürün güncellendi : "+product.getProductId() +" , "+product.getProductName()+" , "+product.getSalesPrice());
    }

    @Override
    public void deleteProduct(long productId) {
        System.out.println("ürün Silindi = "+productId);
    }
}
