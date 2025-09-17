package com.example.customer.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "products") // MongoDB collection name
public class Product {

    @Id
    private String id;
    private String name;         // Product name
    private String description;  // Short description
    private double price;        // Product price
    private int stock;           // Stock quantity
    private String category;     // e.g., "Food", "Beverage", "Snack"
    private List<String> tags;   // ✅ Array of tags (e.g. ["laptop", "tech", "computer"])

    // Default constructor
    public Product() {}

    // Parameterized constructor (without id)
    public Product(String name, String description, double price, int stock, String category, List<String> tags) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.tags = tags;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
