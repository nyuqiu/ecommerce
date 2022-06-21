package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.controller.ProductController;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {
    @Autowired
    private ProductRepository productRepository;

    Product product1 = new Product();
    Product product2 = new Product();
    Product product3 = new Product();
    Product product4 = new Product();

    @Before
    public void setup() {
        //Given
        product1.setTitle("Acer 6574");
        product1.setContent("laptop for business");
        product1.setPrice(3000);

        product2.setTitle("Dell 7878");
        product2.setContent("PC");
        product2.setPrice(2500);

        product3.setTitle("Mastercook");
        product3.setContent("modern cooker");
        product3.setPrice(1000);

        product4.setTitle("FridgeBeko");
        product4.setContent("modern fridge class A+");
        product4.setPrice(1500);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
    }

    @After
    public void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    public void testSaveProductsAndFindAll() {

        //When
        List<Product> products = productRepository.findAll();
        double price = productRepository.findAll().get(1).getPrice();

        //Then
        Assert.assertEquals(4, products.size());
        Assert.assertEquals(2500, price, 0);
    }

    @Test
    public void testFindProductById() {

        //When
        Long id = product2.getId();
        Optional<Product> readProduct = productRepository.findById(id);

        //Then
        Assert.assertTrue(readProduct.isPresent());
        readProduct.ifPresent(product2 -> Assert.assertEquals(id, product2.getId()));
    }

    @Test
    public void testDeleteById() {

        //When
        Long id = product3.getId();
        productRepository.deleteById(id);

        //Then
        Assert.assertEquals(3, productRepository.findAll().size());
    }

}
