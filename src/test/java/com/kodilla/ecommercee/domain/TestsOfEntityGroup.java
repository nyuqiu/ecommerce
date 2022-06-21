package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
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
public class TestsOfEntityGroup {

    @Autowired
    private GroupRepository groupRepository;

    private Group groupComputers;
    private Group groupAgd;

    @Before
    public void setUp() {
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

        List<Product> productsComputers = new ArrayList<>();
        productsComputers.add(product1);
        productsComputers.add(product2);
        List<Product> productsAgd = new ArrayList<>();
        productsAgd.add(product3);
        productsAgd.add(product4);

        groupComputers = new Group();
        groupComputers.setGroupName("computers");
        groupComputers.setProducts(productsComputers);

        groupAgd = new Group();
        groupAgd.setGroupName("agd");
        groupAgd.setProducts(productsAgd);

        groupRepository.save(groupComputers);
        groupRepository.save(groupAgd);
    }

    @Test
    public void testCreateGroup() {

        //When
        List<Group> groups = groupRepository.findAll();
        double price = groupComputers.getProducts().get(1).getPrice();

        //Then
        Assert.assertEquals(2, groups.size());
        Assert.assertEquals(2500, price, 0);
    }

    @Test
    public void testReadGroupById() {

        //When
        Long id = groupComputers.getId();
        Optional<Group> readGroups = groupRepository.findById(id);

        //Then
        Assert.assertTrue(readGroups.isPresent());
        readGroups.ifPresent(group1 -> Assert.assertEquals(id, group1.getId()));
    }

    @Test
    public void testUpdateGroupName() {

        //When
        groupComputers.setGroupName("computersRebranded");
        Optional<Group> groupRebranded = groupRepository.findByGroupName(groupComputers.getGroupName());
        String nameRebranded = groupRebranded.get().getGroupName();

        //Then
        Assert.assertEquals("computersRebranded", nameRebranded);
    }

    @Test
    public void testDeleteById() {

        //When
        Long idComputers = groupComputers.getId();
        Long idAgd = groupAgd.getId();
        groupRepository.deleteById(idComputers);
        groupRepository.deleteById(idAgd);
        List<Group> groups = groupRepository.findAll();

        //Then
        Assert.assertEquals(0, groups.size());
    }
}