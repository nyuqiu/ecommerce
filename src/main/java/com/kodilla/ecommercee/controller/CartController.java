package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/carts")
public class CartController {
    @GetMapping(value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam Long cartID) {
        List<ProductDto> res = new ArrayList<>();
        res.add(new ProductDto());
        return res;
    }

    @PutMapping(value = "addProductToCart")
    public CartDto addProductToCart(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @PostMapping(value = "createEmptyCart")
    public CartDto createEmptyCart() {
        return new CartDto();
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart() {
    }

    @PostMapping(value = "createOrderFromCart")
    public OrderDto createOrderFromCart() {
        return new OrderDto();
    }
}