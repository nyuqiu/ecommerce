package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDto {

    private long id;
    private String title;
    private String content;
    private double price;
    private Cart cart;
    private Group group;
}
