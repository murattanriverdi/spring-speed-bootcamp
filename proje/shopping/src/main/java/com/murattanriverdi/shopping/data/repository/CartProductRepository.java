package com.murattanriverdi.shopping.data.repository;

import com.murattanriverdi.shopping.data.entity.CartProduct;
import com.murattanriverdi.shopping.data.entity.CartStatus;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
    @Modifying
    @Query("select cp from CartProduct cp where cp.cart.cartId= :cartId and cp.productId= :productId and cp.cart.cartStatus=0")
    Iterable<CartProduct> getCartProductByCartIdAndProductId(@Param("cartId")long cartId, @Param("productId")long productId);
}
