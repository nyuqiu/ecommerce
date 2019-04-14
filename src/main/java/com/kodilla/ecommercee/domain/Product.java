package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;
    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "products"
    )
    private List<Group> groups;
}
