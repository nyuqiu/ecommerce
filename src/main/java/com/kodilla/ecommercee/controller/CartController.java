package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.CartNotFoundException;
import com.kodilla.ecommercee.controller.exception.ProductNotFoundException;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.OrderDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/carts")
public class CartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartDbService service;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderMapper orderMapper;

    @GetMapping(value = "getProductsFromCart")
    public List<ProductDto> getProductsFromCart(@RequestParam("id") Long cartId) throws CartNotFoundException {
        LOGGER.info("Return products from cart");
        return productMapper.mapToProductDtoList(cartMapper.mapToCartDto(service.getProductsFromCart(cartId)
                .orElseThrow(CartNotFoundException::new)).getProducts());
    }

    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestBody CartDto cartDto,
                                 @RequestParam("id") Long productId) throws ProductNotFoundException {
        LOGGER.info("Add product to cart");
        cartMapper.mapToCartDto(service.addProductToCart(productId, cartMapper.mapToCart(cartDto)));
    }

    @PostMapping(value = "createEmptyCart")
    public CartDto createEmptyCart() {
        LOGGER.info("Create empty cart");
        return cartMapper.mapToCartDto(service.createCart(cartMapper.mapToCart(new CartDto())));
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestBody CartDto cartDto,
                                      @RequestParam("id") Long productId) throws ProductNotFoundException {
        LOGGER.info("Delete product from cart");
        service.deleteProductFromCart(productId, cartMapper.mapToCart(cartDto));
    }

    @PostMapping(value = "createOrderFromCart")
    public OrderDto createOrderFromCart(@RequestParam("id") Long cartId) throws CartNotFoundException {
        LOGGER.info("Create order from cart");
        return orderMapper.mapToOrderDto(service.createOrderFromCart(cartId));
    }
}
