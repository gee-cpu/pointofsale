package com.gonchaba.shopping.cart.pos.service;

import com.gonchaba.shopping.cart.pos.dto.CartDTO;
import com.gonchaba.shopping.cart.pos.entity.Cart;

import java.util.List;

public interface CartService {   List<CartDTO> getAll();

    Cart getOne(Long id);

    default CartDTO add(CartDTO obj) {
        return null;
    }

    void delete(Long id);

}
