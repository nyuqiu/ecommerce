package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exception.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDbService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(final Long id) throws ProductNotFoundException {
        return repository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Product saveProduct(final Product product) {
        return repository.save(product);
    }

    public void deleteProductById(final Long id) throws ProductNotFoundException {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ProductNotFoundException();
        }
    }
}
