package com.george.store.controllers;

import com.george.store.database.entities.CustomerEntity;
import com.george.store.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerEntity> getAll(){
        return customerService.findAll();
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerEntity customerEntity){
        customerService.createCustomer(customerEntity);
    }

}
