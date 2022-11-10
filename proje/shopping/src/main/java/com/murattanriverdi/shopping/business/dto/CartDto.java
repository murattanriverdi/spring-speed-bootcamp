package com.murattanriverdi.shopping.business.dto;

import java.util.List;

public class CartDto {
    private long cartId;
    private String customerName;
    private List<CartProductDto> cardProducts;

    public CartDto() {
    }

    public CartDto(long cartId, String customerName, List<CartProductDto> cardProducts) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cardProducts = cardProducts;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<CartProductDto> getCardProducts() {
        return cardProducts;
    }

    public void setCardProducts(List<CartProductDto> cardProducts) {
        this.cardProducts = cardProducts;
    }
}
