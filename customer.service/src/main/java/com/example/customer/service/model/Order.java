package com.example.customer.service.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;
@Document(collection="orders")
public class Order {
	@Id
    private String id;
    private String userId;
    private List<item> items;
    private double totalAmount;
    private String status;
    private LocalDateTime createdAt;
	public Order(String id, String userId, List<item> items, double totalAmount, String status,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.items = items;
		this.totalAmount = totalAmount;
		this.status = status;
		this.createdAt = createdAt;
	}
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
	public List<item> getItems() {
		return items;
	}
	public void setItems(List<item> items) {
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
