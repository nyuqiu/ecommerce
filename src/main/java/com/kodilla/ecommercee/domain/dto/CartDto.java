package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private User user;
    private List<Product> products = new ArrayList<>();
    private Order order;
}
