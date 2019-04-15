package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.CartNotFoundException;
import com.kodilla.ecommercee.controller.exception.ProductNotFoundException;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/carts")
public class CartController {
    @Autowired
    private DbService service;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CartMapper cartMapper;

    @GetMapping({"id"})
    public List<ProductDto> getProductsFromCart(@PathVariable("id") Long cartId) throws CartNotFoundException {
        return productMapper.mapToProductDtoList(cartMapper.mapToCartDto(service.getProductsFromCart(cartId).orElseThrow(CartNotFoundException::new)).getProducts());
    }

    @PutMapping({"id"})
    public void addProductToCart(@RequestBody CartDto cartDto, @PathVariable("id") Long productId) throws ProductNotFoundException{
        cartMapper.mapToCartDto(service.addProductToCart(productId, cartMapper.mapToCart(cartDto)));
    }

    @PostMapping()
    public CartDto createEmptyCart() {
        return cartMapper.mapToCartDto(service.createCart(cartMapper.mapToCart(new CartDto())));
    }

    @DeleteMapping({"id"})
    public void deleteProductFromCart(@PathVariable("id") Long productId, @RequestBody CartDto cartDto) {

    }

    @PostMapping({"id"})
    public OrderDto createOrderFromCart(@PathVariable("id") Long cartId) {
        return new OrderDto();
    }
}
