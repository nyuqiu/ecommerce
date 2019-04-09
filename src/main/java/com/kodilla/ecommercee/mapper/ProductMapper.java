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
                productDto.getTitle(),
                productDto.getContent());
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getContent());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> taskList){
        return taskList.stream()
                .map(t -> new ProductDto(t.getId(), t.getTitle(), t.getContent()))
                .collect(Collectors.toList());
    }
}
