package com.example.loginlogoutsample.service;

import com.example.loginlogoutsample.dao.CustomerDao;
import com.example.loginlogoutsample.entity.Customer;
import com.example.loginlogoutsample.entity.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;
    private final PasswordEncoder passwordEncoder;

    public List<Customer> findAllCustomers(){
        return customerDao.findAll();
    }
    @Transactional
    public void saveCustomer(Customer customer){
        Set<Roles> set = customerRoles(customer.getRoleName());
        customer.setRoles(set);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerDao.save(customer);
    }

    public Set<Roles> customerRoles(String roleName){
        if (roleName != null && roleName.isBlank()){
            return null;
        } if ( roleName.contains(",")){
            String [] roles = roleName.split(",");
            return Stream.of(roles).map(s -> {
                Roles ro = new Roles();
                ro.setName(s);
                return  ro;
            }).collect(Collectors.toSet());
        } else {
            Roles roles = new Roles();
            roles.setName(roleName);
            Set<Roles> rolesSet = new HashSet<>();
            rolesSet.add(roles);
            return rolesSet;
        }

    }
}
