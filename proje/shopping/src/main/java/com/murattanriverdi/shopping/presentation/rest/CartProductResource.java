package com.murattanriverdi.shopping.presentation.rest;

import com.murattanriverdi.shopping.business.dto.CartProductDto;
import com.murattanriverdi.shopping.business.service.CartProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopping")
public class CartProductResource {

    private CartProductService cartProductService;

    public CartProductResource(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }

    @PostMapping("/cart/add")
    public ResponseEntity<?> addCartProduct(@RequestBody CartProductDto cartProductDto){
        cartProductService.addCartProduct(cartProductDto);
        return ResponseEntity.ok("Ürün Sepete Eklendi");
    }

    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public ResponseEntity<?> removeCartProduct(@PathVariable("cartId")long cartId, @PathVariable("productId")long productId){
            cartProductService.removeCartProduct(cartId,productId);
        return  ResponseEntity.ok("Ürün Sepetten Silindi1!");
    }
}
