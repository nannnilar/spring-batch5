package com.example.jpa_onetoone.service;

import com.example.jpa_onetoone.dao.AddressDao;
import com.example.jpa_onetoone.dao.CustomerDao;
import com.example.jpa_onetoone.ds.Address;
import com.example.jpa_onetoone.ds.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private final CustomerDao customerDao;
    private final AddressDao addressDao;

    public CustomerService(CustomerDao customerDao, AddressDao addressDao) {
        this.customerDao = customerDao;
        this.addressDao = addressDao;
    }
    @Transactional
    public void createDb(){
        Customer customer1 = new Customer("John","Doe","john@gamil.com");
        Customer customer2 = new Customer("Thomas","Hardy","thomas@gamil.com");
        Customer customer3 = new Customer("Charles","Dickens","charles@gamil.com");
        Customer customer4 = new Customer("Thaw Thaw","Htun Zaw","thaw@gamil.com");
        Customer customer5 = new Customer("Thu Thu","Hnin Wai","thu@gamil.com");


        Address address1 = new Address("Love Lane","Thanlyin");
        Address address2 = new Address("Dream Lane","Mandalay");
        Address address3 = new Address("79 Park Avenue","Yangon");

        customer1.addAddress(address1);
        customer2.addAddress(address2);
        customer3.addAddress(address3);

        /*address1.setCustomer(customer1);
        address2.setCustomer(customer2);
        address3.setCustomer(customer3);*/

        /*customer1.setAddress(address1);
        address1.setCustomer(customer1);
        customer2.setAddress(address2);
        address2.setCustomer(customer2);
        customer3.setAddress(address3);
        address3.setCustomer(customer3);*/

        /*addressDao.save(address1);
        addressDao.save(address2);
        addressDao.save(address3);*/
        customerDao.save(customer1);
        customerDao.save(customer2);
        customerDao.save(customer3);
        customerDao.save(customer4);
        customerDao.save(customer5);
    }
}
