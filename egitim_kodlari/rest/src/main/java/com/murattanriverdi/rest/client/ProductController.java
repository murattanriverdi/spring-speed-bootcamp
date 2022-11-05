package com.murattanriverdi.rest.client;

import com.murattanriverdi.rest.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductController {

    @GetMapping("/product/get")
    @ResponseBody
    public String getProduct() {
        long productId = 303;

        //Product product =  new Product(productId, "Cep Telefonu", 1450);

        //Rest Client => Rest Service Controller içinde  çağırıp onu rest client gibi davranıp test etmiş olduk
        String url = "http://localhost:8080/api/product/" + productId;
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println("Ürün :" + product.getProductName());
        return "Edinme Başarılı! => Ürün: " + product.getProductName() +" "+product.getSalesPrice();
    }

    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct() {
        Product product = new Product(0, "Fritöz", 645);
        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        Product result = restTemplate.postForObject(url, product, Product.class);
        return "Yollama Başarılı! => "+ result.getProductId();

    }

    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct() {
        Product product = new Product(302, "Bulaşık Makinesi", 7000);
        String url = "http://localhost:8080/api/product/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Product>(product),Void.class);
        return "Güncelleme Başarılı";

    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct() {
      long productId=303;
        String url = "http://localhost:8080/api/product/"+productId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "Silme Başarılı";

    }



}
