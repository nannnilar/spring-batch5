package com.example.reactivemongo.controller;

import com.example.reactivemongo.dto.ProductDto;
import com.example.reactivemongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/all")
    public Flux<ProductDto> findAll(){
        return productService.findAll();
    }
//    64d0a0d8daa2e51a956d4132
    @PostMapping("/insert")
    public Mono<ProductDto> insertProduct(@RequestBody Mono<ProductDto> productDtoMono){
        return productService.insertProduct(productDtoMono);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id){
         productService.deleteProduct(id);
    }
    @GetMapping("{id}")
    public Mono<ResponseEntity<ProductDto>> findProductById(@PathVariable String id){
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable String id,
                                                          @RequestBody Mono<ProductDto> productDtoMono){
        return productService.updateProduct(id,productDtoMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
