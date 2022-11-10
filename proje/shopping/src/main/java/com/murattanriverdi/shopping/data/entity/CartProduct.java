package com.murattanriverdi.shopping.data.entity;

import javax.persistence.*;

@Entity
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;

    private long productId;

    private int salesQuantity;

    private double salesPrice;


    @ManyToOne(targetEntity = Cart.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartProduct() {
    }

    public CartProduct(long cartProductId, long productId, int salesQuantity, double salesPrice) {
        this.cartProductId = cartProductId;
        this.productId = productId;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
