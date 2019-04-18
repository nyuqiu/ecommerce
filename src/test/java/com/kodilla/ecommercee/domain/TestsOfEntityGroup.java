package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestsOfEntityGroup {

    @Autowired
    private GroupRepository groupRepository;

    private Group group;
    private Group group2;

    @Before
    public void setUp() {
        //Given
        Product product1 = new Product();
        Long id = product1.getId();
        product1.setId(id);
        product1.setTitle("Acer 6574");
        product1.setContent("laptop for business");
        product1.setPrice(3000);

        Product product2 = new Product();
        Long id2 = product2.getId();
        product2.setId(id2);
        product2.setTitle("Dell 7878");
        product2.setContent("PC");
        product2.setPrice(2500);

        Product product3 = new Product();
        Long id3 = product3.getId();
        product3.setId(id3);
        product3.setTitle("Mastercook");
        product3.setContent("modern cooker");
        product3.setPrice(1000);

        Product product4 = new Product();
        Long id4 = product4.getId();
        product4.setId(id4);
        product4.setTitle("FridgeBeko");
        product4.setContent("modern fridge class A+");
        product4.setPrice(1500);

        List<Product> productsNew = new ArrayList<>();
        productsNew.add(product1);
        productsNew.add(product2);
        List<Product> productsOld = new ArrayList<>();
        productsNew.add(product3);
        productsOld.add(product4);

        group = new Group();
        group.setId(1L);
        group.setGroupName("media");
        group.setProducts(productsNew);

        group2 = new Group();
        ;
        group2.setId(2L);
        group2.setGroupName("agd");
        group2.setProducts(productsOld);

        groupRepository.save(group);
        groupRepository.save(group2);
    }

    @Test
    public void testCreateGroup() {

        //When
        List<Group> groups = groupRepository.findAll();
        double price = group.getProducts().get(1).getPrice();

        //Then
        Assert.assertEquals(2, groups.size());
        Assert.assertEquals(2500, price, 0);

        //CleanUp
        groupRepository.delete(group);
        groupRepository.delete(group2);
    }

    @Test
    public void testReadGroupById() {

        //When
        Long id = group.getId();
        Optional<Group> readGroups = groupRepository.findById(id);

        //Then
        Assert.assertTrue(readGroups.isPresent());
        readGroups.ifPresent(group1 -> Assert.assertEquals(id, group1.getId()));

        //CleanUp
        groupRepository.delete(group);
        groupRepository.delete(group2);
    }

    @Test
    public void testUpdateGroupName() {

        //When
        Long id = group.getId();
        group.setGroupName("computers");

        //Then
        Assert.assertEquals("computers", group.getGroupName());

        //CleanUp
        groupRepository.delete(group2);
        groupRepository.delete(group);
    }

    @Test
    public void testDELETEDeleteById() {

        //When
        Long id = group.getId();
        Long id2 = group2.getId();
        groupRepository.deleteById(id);
        groupRepository.deleteById(id2);
        List<Group> groups = groupRepository.findAll();

        //Then
        Assert.assertEquals(0, groups.size());
    }
}