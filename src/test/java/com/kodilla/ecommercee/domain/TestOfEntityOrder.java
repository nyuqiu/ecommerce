package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOfEntityOrder {
    @Autowired
    private OrderRepository orderRepository;

    private Cart cart;
    private List <Order> orders;
    private User user;

    @Before
    public void setup() {
        Cart cart = new Cart();
        List <Order> orders = new ArrayList <>();
        User user = new User().toBuilder()
                .id(1L)
                .firstName("Adam")
                .lastName("Nowak")
                .birthDate(LocalDate.of(2000, 8, 8))
                .address("Warsaw")
                .login("Adam")
                .password("Adam")
                .isBlocked(false)
                .uuid("1234")
                .beginValidityOfUuid(LocalTime.of(20, 04, 14))
                .endValidityOfUuid(LocalTime.of(21, 04, 30))
                .cart(cart)
                .orders(orders)
                .build();
    }

    @Test
    public void testFindAll() {
        //When
        Order order1 = orderRepository.save(new Order(3L, cart, user));
        Order order2 = orderRepository.save(new Order(1L, cart, user));
        Order order3 = orderRepository.save(new Order(2L, cart, user));
        Order order4 = orderRepository.save(new Order(5L, cart, user));

        //Then
        assertEquals(3, orderRepository.count());
    }

    @Test
    public void testFindById() {
        //Given
        Order order = orderRepository.save(new Order(1L, cart, user));
        Long id = order.getId();

        //When
        Order testOrder = orderRepository.findById(id).orElse(null);

        //Then
        assertEquals((order), testOrder);
    }

    @Test
    public void testSaveOrder() {
        //Given
        Order order = new Order(1L, cart, user);
        long ordersListSizeBefore = orderRepository.count();

        //When
        orderRepository.save(order);

        //Then
        assertEquals(ordersListSizeBefore + 1, orderRepository.count());
    }

    @Test
    public void testDeleteOrder() {
        //Given
        Order order = orderRepository.save(new Order(1L, cart, user));

        //When
        orderRepository.delete(order);

        //Then
        assertFalse(orderRepository.findAll().contains(order));
    }
}






