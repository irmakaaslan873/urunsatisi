package com.urunsatisi.urunsatisi.controller;

import com.urunsatisi.urunsatisi.entities.Cart;
import com.urunsatisi.urunsatisi.request.CartRequest;
import com.urunsatisi.urunsatisi.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/id")
    public Optional<Cart> getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }



    public List<Cart> getAllCart(@PathVariable int id) {
        return cartService.getAllCart(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
    @PutMapping("/products/{id}")
    public Cart updateCart(@PathVariable int id, @RequestBody CartRequest request) {
        return cartService.updateCartById(request);

    }
    @PostMapping("/add/{id}")
    public Optional<Cart> addProduct(@PathVariable int id, @RequestBody CartRequest request) {
       return cartService.addCartById(request);
    }



}
