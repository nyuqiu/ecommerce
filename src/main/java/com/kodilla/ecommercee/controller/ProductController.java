package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.ProductNotFoundException;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductDbService service;
    @Autowired
    private ProductMapper mapper;


    @GetMapping
    public List<ProductDto> getProducts() {
        LOGGER.info("Return all products");
        return mapper.mapToProductDtoList(service.getAllProducts());
    }

    @GetMapping("{id}")
    public ProductDto getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        LOGGER.info("Return one product");
        return mapper.mapToProductDto(service.getProductById(productId));
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {
        LOGGER.info("Product is deleted");
        service.deleteProductById(productId);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        LOGGER.info("Product is updated");
        return mapper.mapToProductDto(service.saveProduct(mapper.mapToProduct(productDto)));
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto productDto) {
        LOGGER.info("Product is created");
        service.saveProduct(mapper.mapToProduct(productDto));
    }
}
