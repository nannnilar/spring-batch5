package com.example.reactivemongo.repository;

import com.example.reactivemongo.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product,String> {

}
