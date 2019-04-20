package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Setter(value = AccessLevel.PUBLIC)
@Getter
public class User {

    @Column(name = "USER_ID")
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRSTNAME")
    @NotNull
    private String firstName;

    @Column(name = "LASTNAME")
    @NotNull
    private String lastName;

    @Column(name = "BIRTHDATE")
    @NotNull
    private LocalDate birthDate;

    @Column(name = "ADRESS")
    private String adress;

    @Column(name = "LOGIN")
    @NotNull
    private String login;

    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @Column(name = "IS_BLOCKED")
    private boolean isBlocked;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "BEGIN_VALIDITY_UUID")
    private LocalTime beginValidityOfUuid;

    @Column(name = "END_VALIDITY_UUID")
    private LocalTime endValidityOfUuid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Order> orders = new ArrayList<>();


}