package com.murattanriverdi.commerce.presentation.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/commerce/inventory")
public class ProductResource {

    private final String BASE_URL = "http://localhost:8081/api/inventory/";
    public RestTemplate restTemplate;

    public ProductResource(){
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/products/{categoryId}")
    public Object getProductsByCategory(@PathVariable("categoryId")long categoryId){
        String url = BASE_URL+"products/"+categoryId;
        HttpEntity<String> entity = new HttpEntity<>("Gövde");
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity,Object.class);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @GetMapping("/product/{id}")
    public Object getProduct(@PathVariable("id")long id){
        String url = BASE_URL+"product/"+id;
        HttpEntity<String> entity = new HttpEntity<>("Gövde");
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity,Object.class);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

}
