package com.urunsatisi.urunsatisi.services;

import com.urunsatisi.urunsatisi.entities.Cart;
import com.urunsatisi.urunsatisi.repository.CartRepository;
import com.urunsatisi.urunsatisi.repository.ProductRepository;
import com.urunsatisi.urunsatisi.request.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;


    public Optional<Cart> getCartById(Long id) {
return cartRepository.findById(id);
    }

    public List<Cart> getAllCart(int id) {
        return cartRepository.findAll();
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public Cart updateCartById(CartRequest request) {
    Cart cart=new Cart();
    return cartRepository.save(cart);
    }

    public Optional<Cart> addCartById(CartRequest request) {
        Optional<Cart> cart=cartRepository.findById(request.getCartId());
        return cartRepository. findById(request. getCartId());

    }
}
