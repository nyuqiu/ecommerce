package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getProducts());
    }

    public CartDto mapToCartDto(final Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getProducts());
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList){
        return cartList.stream()
                .map(t -> new CartDto(t.getId(), t.getProducts()))
                .collect(Collectors.toList());
    }
}
