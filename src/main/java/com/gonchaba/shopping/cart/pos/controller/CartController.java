package com.gonchaba.shopping.cart.pos.controller;

import com.gonchaba.shopping.cart.pos.dto.CartDTO;
import com.gonchaba.shopping.cart.pos.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
@GetMapping
public List<CartDTO>CartList(){
    return cartService.getAll();
}

@PostMapping
public CartDTO addCart(@RequestBody CartDTO dto)
{
    return cartService.add(dto);
}

}