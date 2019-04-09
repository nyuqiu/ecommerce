package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/carts")
public class CartController {
    @GetMapping()
    public List<ProductDto> getProductsFromCart(@RequestBody CartDto cartDto) {
        return new ArrayList<>();
    }

    @PutMapping({"id"})
    public CartDto addProductToCart(@RequestBody CartDto cartDto, @PathVariable("id") Long cartId) {
        return new CartDto();
    }

    @PutMapping()
    public CartDto createEmptyCart(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @DeleteMapping({"id"})
    public void deleteProductFromCart(@PathVariable("id") Long productId, @RequestBody CartDto cartDto) {

    }

    @PostMapping()
    public OrderDto createOrderFromCart(@RequestBody CartDto cartDto) {
        return new OrderDto();
    }
}
