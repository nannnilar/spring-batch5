package com.example.graphqlclientdemo.respository;

import com.example.graphqlclientdemo.model.Country;
import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepository extends ListCrudRepository<Country,Integer> {
}
