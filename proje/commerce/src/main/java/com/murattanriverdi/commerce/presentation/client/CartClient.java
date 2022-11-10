package com.murattanriverdi.commerce.presentation.client;

import com.murattanriverdi.commerce.business.dto.CartDto;
import com.murattanriverdi.commerce.business.dto.CartProductDto;
import com.murattanriverdi.commerce.business.dto.ProductDto;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/commerce/shopping")
public class CartClient {

    private final String BASE_URL = "http://localhost:8080/api/commerce/shopping/";
    public RestTemplate restTemplate;

    public CartClient() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/cart/create")
    public ResponseEntity<?> getCartId() {
        String url = BASE_URL+"cart/create";
        HttpHeaders headers = new HttpHeaders();
        headers.add("customerName","murat tanriverdi");
        HttpEntity<String> entity = new HttpEntity<>("Gövde",headers);
        ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.GET, entity, Long.class);
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/cart/add")
    public ResponseEntity<?> addCart() {
        long cartId = (Long) getCartId().getBody();
        ProductDto productDto = getProductById(1);
        if(null == productDto){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ürün Bulunamadı!");
        }
        CartProductDto cartProductDto = new CartProductDto(0,productDto.getProductId(),productDto.getProductName(),cartId,4, productDto.getSalesPrice());
        String url = BASE_URL+"cart/add";
        String message = restTemplate.postForObject(url, cartProductDto, String.class);
        return ResponseEntity.ok(message);
    }


    @GetMapping("/cart/remove")
    public ResponseEntity<?> removeCart() {
        long cartId = (Long) getCartId().getBody();
        long productId = 1;
        String url = BASE_URL +"cart/"+ cartId + "/remove/" + productId;
        restTemplate.delete(url);
        return ResponseEntity.ok("Ürün Sepetten Silindi1!");
    }

    @GetMapping("/checkout")
    public ResponseEntity<?> checkout() {
        long cartId =1;
        String url = BASE_URL+"checkout/" + cartId;
        HttpEntity<String> entity = new HttpEntity<>("Gövde");
        ResponseEntity<String> responseEntity = restTemplate.exchange(url,HttpMethod.GET,entity,String.class);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @GetMapping("/cart/find")
    public ResponseEntity<?> findCartById() {
        long cartId=1;
        String url = BASE_URL+"cart/find/" + cartId;
        HttpEntity<String> entity = new HttpEntity<>("Gövde");
        ResponseEntity<CartDto> responseEntity = restTemplate.exchange(url,HttpMethod.GET,entity, CartDto.class);

        CartDto cartDto = responseEntity.getBody();

        // TODO: Revize edilebilir yapıya uymak için bu şekilde istek atıp ürün adını aldım.
        if(null != cartDto){
            cartDto.getCardProducts().forEach(cartProductDto -> {
                ProductDto productDto = getProductById(cartProductDto.getProductId());
                cartProductDto.setProductName(productDto.getProductName());
            });
        }


        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }


    private ProductDto getProductById(long productId){
        String productUrl = "http://localhost:8080/api/commerce/inventory/product/"+productId;
        return restTemplate.getForObject(productUrl, ProductDto.class);
    }
















}
