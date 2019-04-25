package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT_GROUPS")
@Setter(value = AccessLevel.PUBLIC)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Group {

    @Id
    @Column(name = "GROUP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @Column(name = "PRODUCT_LIST")
    private List<Product> products = new ArrayList<>();
}
