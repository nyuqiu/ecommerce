package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARTS")
@Setter(AccessLevel.PUBLIC)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @Column(name = "CART_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(targetEntity = Product.class,
            mappedBy = "cart",
            fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
}