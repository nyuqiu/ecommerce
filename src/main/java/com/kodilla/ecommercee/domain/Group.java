package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(value = AccessLevel.PUBLIC)
@Entity(name = "GROUPS")
public class Group {

    @Id
    @Column(name = "GROUP_ID")
    private Long id;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "PRODUCT_LIST")
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Product> products;
}
