package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Setter(AccessLevel.PUBLIC)
@Entity
@Table(name = "CARTS")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private Long id;
    private List<Product> products = new ArrayList<>();
    private User user;
    private Order order;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "cart",
            fetch = FetchType.LAZY)
    public List<Product> getProducts() {
        return products;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    public Order getOrder() {
        return order;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    public Long getId() {
        return id;
    }
}