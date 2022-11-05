package com.murattanriverdi.rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TransferController {

    @GetMapping("/client/header")
    @ResponseBody
    public String getHeader() {
        String url = "http://localhost:8080/transfer/header";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("input","Godoro");
        HttpEntity<String> entity = new HttpEntity<>("Gövde",headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return "Başlık Gönderildi >  " + response.getBody();
    }

    @GetMapping("/client/setheader")
    @ResponseBody
    public String setHeader() {
        String url = "http://localhost:8080/transfer/setheader";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>("Gövde");
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
       String input =  response.getHeaders().getFirst("input");
        return "Başlık Alındı >  " + input;
    }

}
