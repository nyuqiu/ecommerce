package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CARTS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cart   {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany( targetEntity = Product.class,
            mappedBy = "cart",
            fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

}