package com.example.customer.service.model;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// If you use SQL instead of Mongo, replace with @Entity, @Table("orders")
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String userId;
    private List<OrderItem> items;
    private double totalAmount;
    private String status;
    private LocalDateTime createdAt;

    // Getters & Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
