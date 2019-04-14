package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    private Long id;
    private Cart cart;
    private List<Group> groups;
}
