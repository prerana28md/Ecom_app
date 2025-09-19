package com.example.customer.service.model;

public class item {
	public class Item {
	    private String productId;
	    private int qty;
	    private double price;

	    public Item(String productId, int qty, double price) {
	        this.productId = productId;
	        this.qty = qty;
	        this.price = price;
	    }

	    // Getters and setters
	    public String getProductId() { return productId; }
	    public void setProductId(String productId) { this.productId = productId; }

	    public int getQty() { return qty; }
	    public void setQty(int qty) { this.qty = qty; }

	    public double getPrice() { return price; }
	    public void setPrice(double price) { this.price = price; }
	}

}
