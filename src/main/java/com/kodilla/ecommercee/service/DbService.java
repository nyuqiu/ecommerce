package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exception.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    public Optional<Cart> getProductsFromCart(Long id){
        return cartRepository.findById(id);
    }

    public Cart addProductToCart(Long productId, final Cart cart) throws ProductNotFoundException{
        cart.getProducts().add(productRepository.findById(productId).orElseThrow(ProductNotFoundException::new));
        return cartRepository.save(cart);
    }

    public Cart createCart(final Cart cart){
        return cartRepository.save(cart);
    }
}
