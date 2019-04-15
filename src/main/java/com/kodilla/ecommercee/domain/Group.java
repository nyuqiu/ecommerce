package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "GROUPS")
public class Group {

    @Id
    @Column(name = "GROUP_ID")
    private Long id;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "PRODUCTS_LIST")
    @ManyToMany
    @JoinTable(
            name = "JOIN_PRODUCT_GROUP",
            joinColumns = {@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    )
    private List<Product> products;
}