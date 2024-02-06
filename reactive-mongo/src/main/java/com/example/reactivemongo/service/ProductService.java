package com.example.reactivemongo.service;

import com.example.reactivemongo.dto.ProductDto;
import com.example.reactivemongo.entity.Product;
import com.example.reactivemongo.repository.ProductRepository;
import com.example.reactivemongo.util.EntityToDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Flux<ProductDto> findAll(){
        return productRepository.findAll()
                .map(EntityToDto::toDto);
    }
    public Mono<ProductDto> insertProduct(Mono<ProductDto> productDto){
        return productDto.map(EntityToDto::toEntity)
                .flatMap(productRepository::insert)
                .map(EntityToDto::toDto);
    }

    public Mono<Void> deleteProduct(String id){
        return this.productRepository.deleteById(id);
    }
    public Mono<ProductDto> findById(String id){
        return productRepository.findById(id)
                .map(EntityToDto::toDto);
    }
    public Mono<ProductDto> updateProduct(String id,Mono<ProductDto> productDtoMono){
        return productRepository.findById(id)
                .flatMap(p -> productDtoMono.map(EntityToDto::toEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(productRepository::save)
                .map(EntityToDto::toDto);
    }
}
