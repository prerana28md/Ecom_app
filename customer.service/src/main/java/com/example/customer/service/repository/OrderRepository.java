package com.example.customer.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.customer.service.model.Order;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    // Find all orders by userId
    List<Order> findByUserId(String userId);

    // Find orders by status
    List<Order> findByStatus(String status);

    // Find orders created after a specific date
    List<Order> findByCreatedAtAfter(Date date);

    // Find orders with totalAmount greater than a value
    List<Order> findByTotalAmountGreaterThan(double amount);
}