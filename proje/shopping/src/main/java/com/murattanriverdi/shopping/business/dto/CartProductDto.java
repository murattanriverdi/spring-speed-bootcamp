package com.murattanriverdi.shopping.business.dto;

public class CartProductDto {
    private long cartProductId;
    private long productId;
    private String productName;
    private long cartId;
    private int salesQuantity;
    private double salesPrice;

    public CartProductDto() {
    }

    public CartProductDto(long cartProductId, long productId, String productName ,long cartId, int salesQuantity, double salesPrice) {
        this.cartProductId = cartProductId;
        this.productId = productId;
        this.productName = productName;
        this.cartId = cartId;
        this.salesQuantity = salesQuantity;
        this.salesPrice = salesPrice;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }
    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }


    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

}
