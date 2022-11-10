package com.murattanriverdi.commerce.presentation.rest;

import com.murattanriverdi.commerce.business.dto.CartDto;
import com.murattanriverdi.commerce.business.dto.CartProductDto;
import org.apache.coyote.Response;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/api/commerce/shopping")
public class CartResource {

    private final String BASE_URL = "http://localhost:8082/api/shopping/";

    public RestTemplate restTemplate;

    public CartResource() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/cart/create")
    public ResponseEntity<?> getCartId(@RequestHeader(value = "customerName",defaultValue = "")String customerName) {
        String url = BASE_URL+"cart/create";
        HttpHeaders headers = new HttpHeaders();
        headers.add("customerName",customerName);
        HttpEntity<String> entity = new HttpEntity<>("Gövde",headers);
        ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.GET, entity, Long.class);
        return ResponseEntity.ok(response.getBody());
    }

    @PostMapping("/cart/add")
    public ResponseEntity<?> addCart(@RequestBody CartProductDto cartProductDto) {
        String url = BASE_URL+"cart/add";
        String message = restTemplate.postForObject(url, cartProductDto, String.class);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public ResponseEntity<?> addCart(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
        String url = BASE_URL+"cart/" + cartId + "/remove/" + productId;
        restTemplate.delete(url);
        return ResponseEntity.ok("Ürün Sepetten Silindi!");
    }

    @GetMapping("/checkout/{cartId}")
    public ResponseEntity<?> checkout(@PathVariable("cartId") long cartId) {
        String url = BASE_URL+"checkout/" + cartId;
        HttpEntity<String> entity = new HttpEntity<>("Gövde");
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @GetMapping("/cart/find/{cartId}")
    public ResponseEntity<?> findCartById(@PathVariable("cartId") long cartId) {
        String url = BASE_URL+"cart/find/" + cartId;
        HttpEntity<String> entity = new HttpEntity<>("Gövde");
        ResponseEntity<Object> responseEntity = restTemplate.exchange(url,HttpMethod.GET,entity,Object.class);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

}
