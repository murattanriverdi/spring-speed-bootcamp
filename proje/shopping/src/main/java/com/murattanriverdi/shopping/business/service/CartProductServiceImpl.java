package com.murattanriverdi.shopping.business.service;

import com.murattanriverdi.shopping.business.dto.CartProductDto;
import com.murattanriverdi.shopping.data.entity.Cart;
import com.murattanriverdi.shopping.data.entity.CartProduct;
import com.murattanriverdi.shopping.data.repository.CartProductRepository;
import com.murattanriverdi.shopping.data.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService{

    public CartRepository cartRepository;
    public CartProductRepository cartProductRepository;

    public  CartProductServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public void addCartProduct(CartProductDto cartProductDto) {
        CartProduct cartProduct = dtoToEntity(cartProductDto);
        cartProductRepository.save(cartProduct);
    }

    @Override
    public void removeCartProduct(long cartId, long productId) {
        Iterable<CartProduct> cartProductList = cartProductRepository.getCartProductByCartIdAndProductId(cartId,productId);
        cartProductRepository.deleteAll(cartProductList);
    }

    public List<CartProductDto> cartProductListToDto(List<CartProduct> cartProductList){
        List<CartProductDto> cartProductDtoList = new ArrayList<>();
        for(CartProduct cartProduct : cartProductList){
            cartProductDtoList.add(entityToDto(cartProduct));
        }
        return cartProductDtoList;
    }


    private CartProduct dtoToEntity(CartProductDto cartProductDto) {
        CartProduct cartProduct = new CartProduct();
        if (null != cartProductDto) {
            cartProduct.setCartProductId(cartProductDto.getCartProductId());
            Optional<Cart> cartOptional = cartRepository.findById(cartProductDto.getCartId());
            cartOptional.ifPresent(cartProduct::setCart);
            cartProduct.setProductId(cartProductDto.getProductId());
            cartProduct.setSalesPrice(cartProductDto.getSalesPrice());
            cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());
        }
        return cartProduct;
    }

    private CartProductDto entityToDto(CartProduct cartProduct) {
        CartProductDto cartProductDto = new CartProductDto();
        if (null != cartProduct) {


            cartProductDto.setCartProductId(cartProduct.getCartProductId());
            cartProductDto.setCartId(cartProduct.getCart().getCartId());
            cartProductDto.setProductId(cartProduct.getProductId());
            cartProductDto.setSalesPrice(cartProduct.getSalesPrice());
            cartProductDto.setSalesQuantity(cartProduct.getSalesQuantity());
        }
        return cartProductDto;
    }


}
