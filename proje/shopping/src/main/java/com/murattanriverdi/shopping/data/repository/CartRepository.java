package com.murattanriverdi.shopping.data.repository;

import com.murattanriverdi.shopping.data.entity.Cart;
import com.murattanriverdi.shopping.data.entity.CartStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {

     Optional<Cart> findCartByCustomerNameAndCartStatusNot(String customerName,CartStatus cartStatus);

}
