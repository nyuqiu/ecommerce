package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public List<ProductDto> getProducts(){
        LOGGER.info("Return all products");
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) {
        LOGGER.info("Return one product");
        return new ProductDto();
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        LOGGER.info("Product is deleted");
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        LOGGER.info("Product is updated");
        return new ProductDto();
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto productDto){
        LOGGER.info("Product is created");
    }
}
