package com.example.reactivemongo.handler;

import com.example.reactivemongo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductService productService;
}
