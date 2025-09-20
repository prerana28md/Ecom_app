package com.example.customer.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.customer.service.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
	Order findByUserId(String userId);

}
