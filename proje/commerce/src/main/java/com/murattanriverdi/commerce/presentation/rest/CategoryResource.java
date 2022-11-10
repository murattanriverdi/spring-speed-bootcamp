package com.murattanriverdi.commerce.presentation.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/commerce/inventory")
public class CategoryResource {

    private final String BASE_URL = "http://localhost:8081/api/inventory/";
    public RestTemplate restTemplate;

    public CategoryResource(){
        this.restTemplate = new RestTemplate();
    }


    @GetMapping("/categories")
    public ResponseEntity<?> getCategoryList(){
        String url = BASE_URL+"categories";
        HttpEntity<String> entity = new HttpEntity<>("Gövde");
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity,Object.class);
        return  ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }
}
