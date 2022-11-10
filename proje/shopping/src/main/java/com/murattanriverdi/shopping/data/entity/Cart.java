package com.murattanriverdi.shopping.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    private String customerName;
    private double totalAmount;
    private CartStatus cartStatus;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartProduct> cartProductList;


    public Cart() {
    }

    public Cart(long cartId, String customerName, double totalAmount, CartStatus cartStatus) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.cartStatus = cartStatus;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public CartStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(CartStatus cartStatus) {
        this.cartStatus = cartStatus;
    }

    public List<CartProduct> getCartProductList() {
        return cartProductList;
    }

    public void setCartProductList(List<CartProduct> cartProductList) {
        this.cartProductList = cartProductList;
    }
}
