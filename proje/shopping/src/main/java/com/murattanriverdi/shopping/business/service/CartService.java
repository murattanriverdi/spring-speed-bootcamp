package com.murattanriverdi.shopping.business.service;

import com.murattanriverdi.shopping.business.dto.CartDto;

public interface CartService {

    public long create(String customerName);

    public CartDto find(long id);

    public boolean checkout(long cartId);
}
