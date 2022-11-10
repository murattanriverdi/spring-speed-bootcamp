package com.murattanriverdi.shopping.business.service;

import com.murattanriverdi.shopping.business.dto.CartDto;
import com.murattanriverdi.shopping.business.dto.CartProductDto;
import com.murattanriverdi.shopping.data.entity.Cart;
import com.murattanriverdi.shopping.data.entity.CartProduct;
import com.murattanriverdi.shopping.data.entity.CartStatus;
import com.murattanriverdi.shopping.data.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    private CartProductService cartProductService;


    public CartServiceImpl(CartRepository cartRepository,CartProductService cartProductService) {
        this.cartRepository = cartRepository;
        this.cartProductService = cartProductService;
    }

    @Override
    public long create(String customerName) {
        Cart currentCart = findCartByCustomerName(customerName);
        if(null != currentCart){
            return currentCart.getCartId();
        }
        Cart cart = new Cart();
        cart.setCustomerName(customerName);
        cart.setCartStatus(CartStatus.NEW);
        cartRepository.save(cart);
        return cart.getCartId();
    }

    @Override
    public CartDto find(long id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        if(cartOptional.isEmpty()){
            return  null;
        }
        return entityToDto(cartOptional.get());
    }

    @Override
    public boolean checkout(long cartId) {
        Optional<Cart> cartOpt = cartRepository.findById(cartId);
        if(cartOpt.isEmpty()){
            return false;
        }
        Cart cart = cartOpt.get();
        cart.setCartStatus(CartStatus.END);
        cartRepository.save(cart);
        return true;
    }

    private CartDto entityToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        if (null != cart) {
            cartDto.setCartId(cart.getCartId());
            cartDto.setCustomerName(cart.getCustomerName());
            cartDto.setCardProducts(cartProductService.cartProductListToDto(cart.getCartProductList()));
        }
        return cartDto;
    }

    private Cart findCartByCustomerName(String customerName){
        Optional<Cart> cartOptional = cartRepository.findCartByCustomerNameAndCartStatusNot(customerName,CartStatus.END);
        if(cartOptional.isEmpty()){
            return null;
        }
        return cartOptional.get();
    }


}
