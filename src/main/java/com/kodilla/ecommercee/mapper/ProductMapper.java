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
                productDto.getContent(),
                productDto.getPrice(),
                productDto.getCart(),
                productDto.getGroup());
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getContent(),
                product.getPrice(),
                product.getCart(),
                product.getGroup());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(p -> new ProductDto(p.getId(),
                        p.getTitle(),
                        p.getContent(),
                        p.getPrice(),
                        p.getCart(),
                        p.getGroup()))
                .collect(Collectors.toList());
    }
}
