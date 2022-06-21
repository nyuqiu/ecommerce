package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.controller.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserTestSuite {

    @Autowired
    private UserRepository userRepository;

    private User user1 = new User();
    private User user2 = new User();

    @Before
    public void setUp() throws Exception {
        user1.setFirstName("John");
        user1.setLastName("Smith");
        user1.setBirthDate(LocalDate.of(1999, 1, 1));
        user1.setAdress("Stone road 22/2");
        user1.setLogin("smithJ");
        user1.setPassword("randomPassword");
        user2.setFirstName("Lee");
        user2.setLastName("Merlin");
        user2.setBirthDate(LocalDate.of(1987, 12, 19));
        user2.setAdress("Wood street 1");
        user2.setLogin("merlinl");
        user2.setPassword("randomPassword");
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        user1.setCart(cart1);
        user2.setCart(cart2);
        user1.setOrders(Arrays.asList(order1, order2));
        user2.setOrders(Arrays.asList(order3, order4));
        userRepository.save(user1);
        userRepository.save(user2);
    }

    @Test
    public void testCreateUser() throws UserNotFoundException {
        //Given
        int usersSize = userRepository.findAll().size();
        User johnSmith = userRepository.findById(user1.getId()).orElseThrow(UserNotFoundException::new);
        User leeMerlin = userRepository.findById(user2.getId()).orElseThrow(UserNotFoundException::new);
        String johnSmithLogin = johnSmith.getLogin();
        Long johnSmitCartId = johnSmith.getCart().getId();
        int leeMerlinOrderList = leeMerlin.getOrders().size();
        //Then
        assertEquals(2, usersSize);
        assertEquals("smithJ", johnSmithLogin);
        assertNotNull(johnSmitCartId);
        assertEquals(2, leeMerlinOrderList);
    }

    @Test
    public void testUpdateUserLogin() throws UserNotFoundException {
        //Given
        User leeMerlin = userRepository.findById(user2.getId()).orElseThrow(UserNotFoundException::new);
        String leeMerlinNewLogin = "leem";
        //When
        userRepository.findById(user2.getId()).orElseThrow(UserNotFoundException::new).setLogin(leeMerlinNewLogin);
        //Then
        assertEquals(leeMerlinNewLogin, leeMerlin.getLogin());
    }

    @Test
    public void testDeleteUser() {
        //When
        userRepository.deleteById(user2.getId());
        //Then
        assertEquals(1, userRepository.findAll().size());
    }
}