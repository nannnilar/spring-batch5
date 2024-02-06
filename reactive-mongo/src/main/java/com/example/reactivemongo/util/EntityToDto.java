package com.example.reactivemongo.util;

import com.example.reactivemongo.dto.ProductDto;
import com.example.reactivemongo.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityToDto {

    public static ProductDto toDto(Product product){
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }

    public static Product toEntity(ProductDto productDto){
        Product product =new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }
}
