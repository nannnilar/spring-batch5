package com.example.addressservice.controller;

import com.example.addressservice.dao.AddressDao;
import com.example.addressservice.entity.Addresses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressDao addressDao;
    @GetMapping("/addresses")
    public Addresses listAddress(){
        return new Addresses(addressDao.findAll().spliterator());
    }
}
