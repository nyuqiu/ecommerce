package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    public List<Product> getProductsFromCart(final Cart cart){
        return cartRepository.findAllFromCart(cart);
    }

    public Cart addProductToCart(Long id, final Cart cart){
        return cartRepository.addProductToCart(id, cart);
    }

    public Cart createEmptyCart(){
        return cartRepository.saveEmptyCart();
    }
}
