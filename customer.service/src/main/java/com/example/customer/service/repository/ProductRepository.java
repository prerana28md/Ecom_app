package com.example.customer.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.customer.service.model.Product;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    // Find by category
    List<Product> findByCategory(String category);

    // Find by name
    List<Product> findByName(String name);
}