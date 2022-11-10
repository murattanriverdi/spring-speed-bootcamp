package com.murattanriverdi.commerce.presentation.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/commerce/inventory")
public class CategoryClient {

    private final String BASE_URL = "http://localhost:8080/api/commerce/inventory/";


    public RestTemplate restTemplate;

    public CategoryClient(){
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
