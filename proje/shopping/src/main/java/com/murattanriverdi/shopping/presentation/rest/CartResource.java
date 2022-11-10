package com.murattanriverdi.shopping.presentation.rest;

import com.murattanriverdi.shopping.business.dto.CartDto;
import com.murattanriverdi.shopping.business.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping")
public class CartResource {

    private CartService cartService;

    public CartResource(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/cart/create")
    public ResponseEntity<?> crate(@RequestHeader(value = "customerName", defaultValue = "")String customerName){
        long cartId = cartService.create(customerName);
        return ResponseEntity.ok(cartId);
    }

    @GetMapping("/checkout/{cartId}")
    public ResponseEntity<?> checkout(@PathVariable("cartId")long cartId){
        boolean status = cartService.checkout(cartId);
        if(!status){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ödeme Başarısız Sepet Bulunamadı!");
        }
        return  ResponseEntity.ok("Ödeme Başarılı!");
    }

    @GetMapping("/cart/find/{cartId}")
    public ResponseEntity<?> find(@PathVariable("cartId")long cartId){
        CartDto cartDto = cartService.find(cartId);
        if( null == cartDto){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sepet Bulunamadı");
        }
        return ResponseEntity.ok(cartDto);
    }


}
