package com.george.store.controllers;

import com.george.store.database.entities.OrderEntity;
import com.george.store.models.CreateOrderModel;
import com.george.store.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderEntity> findALl(){
        return orderService.findAll();
    }

    @PostMapping
    public void createOrder(@RequestBody CreateOrderModel createOrderModel){
        orderService.createOrder(createOrderModel);
    }


}
