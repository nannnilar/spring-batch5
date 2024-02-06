package com.example.loginlogoutsample.service;

import com.example.loginlogoutsample.dao.CustomerDao;
import com.example.loginlogoutsample.entity.Customer;
import com.example.loginlogoutsample.entity.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerDao customerDao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void register(Customer customer){
        Roles roles = new Roles();
        roles.setName("USER");
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.getRoles().add(roles);
        System.out.println("===============: " + customer);
        customerDao.save(customer);

    }
}
