package com.murattanriverdi.shopping.business.service;

import com.murattanriverdi.shopping.business.dto.CartProductDto;
import com.murattanriverdi.shopping.data.entity.CartProduct;

import java.util.List;

public interface CartProductService {

    public void addCartProduct(CartProductDto cartProductDto);
    public void removeCartProduct(long cartId, long productId);
    public List<CartProductDto> cartProductListToDto(List<CartProduct> cartProductList);
}
