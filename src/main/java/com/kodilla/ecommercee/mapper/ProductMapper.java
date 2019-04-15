package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getCart(),
                productDto.getGroups());
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getCart(),
                product.getGroups());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> taskList){
        return taskList.stream()
                .map(t -> new ProductDto(t.getId(), t.getCart(), t.getGroups()))
                .collect(Collectors.toList());
    }
}
