package com.george.store.services;

import com.george.store.database.entities.CustomerEntity;
import com.george.store.database.entities.OrderEntity;
import com.george.store.database.entities.ProductEntity;
import com.george.store.database.repositories.OrderRepository;
import com.george.store.models.CreateOrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = orderRepository.findAll();
        for(OrderEntity orderEntity : orders){
            orderEntity.setCustomerId(orderEntity.getCustomer().getId());
            orderEntity.setCustomer(null);

            orderEntity.setProductId(orderEntity.getProduct().getId());
            orderEntity.setProduct(null);
        }
        return orders;
    }

    public void createOrder(CreateOrderModel newOrder) {
        CustomerEntity customerEntity = customerService.findOne(newOrder.getCustomerId());
        ProductEntity productEntity = productService.findOne(newOrder.getProductId());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setQuantity(newOrder.getQuantity());
        orderEntity.setCustomer(customerEntity);
        orderEntity.setProduct(productEntity);
        orderEntity.setDate(LocalDateTime.now());
        orderRepository.save(orderEntity);
    }
}
