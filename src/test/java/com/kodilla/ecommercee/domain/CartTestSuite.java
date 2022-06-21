package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;

    Cart cart = new Cart();

    @Before
    public void setup() {
        //Given
        Product product1 = new Product();
        product1.setTitle("Acer 6574");
        product1.setContent("laptop for business");
        product1.setPrice(3000);

        Product product2 = new Product();
        product2.setTitle("Dell 7878");
        product2.setContent("PC");
        product2.setPrice(2500);

        Product product3 = new Product();
        product3.setTitle("Mastercook");
        product3.setContent("modern cooker");
        product3.setPrice(1000);

        Product product4 = new Product();
        product4.setTitle("FridgeBeko");
        product4.setContent("modern fridge class A+");
        product4.setPrice(1500);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        cart.setProducts(products);
        cartRepository.save(cart);
    }

    @After
    public void tearDown() {
        cartRepository.deleteAll();
    }

    @Test
    public void testSaveCartAndFindAll() {

        //When
        List<Cart> products = cartRepository.findAll();
        Double price = cartRepository.findAll().get(0).getProducts().get(1).getPrice();

        //Then
        Assert.assertEquals(1, products.size());
        Assert.assertEquals(2500, price, 0);
    }

    @Test
    public void testFindCartById() {

        //When
        Long id = cart.getId();
        Optional<Cart> readProduct = cartRepository.findById(id);

        //Then
        Assert.assertTrue(readProduct.isPresent());
        readProduct.ifPresent(product2 -> Assert.assertEquals(id, product2.getId()));
    }

    @Test
    public void testDeleteById() {

        //When
        Long id = cart.getId();
        cartRepository.deleteById(id);

        //Then
        Assert.assertEquals(0, cartRepository.findAll().size());
    }
}
