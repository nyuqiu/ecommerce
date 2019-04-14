package com.kodilla.ecommercee.controller;

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

    @GetMapping()
    public List<ProductDto> getProductsFromCart(@RequestBody CartDto cartDto) {
        return productMapper.mapToProductDtoList(service.getProductsFromCart(cartMapper.mapToCart(cartDto)));
    }

    @PutMapping({"id"})
    public CartDto addProductToCart(@RequestBody CartDto cartDto, @PathVariable("id") Long productId) {
        return cartMapper.mapToCartDto(service.addProductToCart(productId, cartMapper.mapToCart(cartDto)));
    }

    @PostMapping()
    public CartDto createEmptyCart() {
        CartDto newCartDto = new CartDto();
        return cartMapper.mapToCartDto(service.createEmptyCart(cartMapper.mapToCart(newCartDto)));
    }

    @DeleteMapping({"id"})
    public void deleteProductFromCart(@PathVariable("id") Long productId, @RequestBody CartDto cartDto) {

    }

    @PostMapping()
    public OrderDto createOrderFromCart(@RequestBody CartDto cartDto) {
        return new OrderDto();
    }
}
