package com.george.store.services;

import com.george.store.database.entities.CustomerEntity;
import com.george.store.database.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void createCustomer(CustomerEntity customerEntity){
        customerRepository.save(customerEntity);
    }

    public List<CustomerEntity> findAll(){
        return customerRepository.findAll();
    }

    public CustomerEntity findOne(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }
}
