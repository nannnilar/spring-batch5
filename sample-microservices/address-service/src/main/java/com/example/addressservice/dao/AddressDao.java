package com.example.addressservice.dao;

import com.example.addressservice.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address,Integer> {

}
