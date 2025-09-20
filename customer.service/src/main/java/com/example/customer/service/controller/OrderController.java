package com.example.customer.service.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.customer.service.model.Order;
import com.example.customer.service.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // Create Order
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // Set createdAt only if not already provided
        if (order.getCreatedAt() == null) {
            order.setCreatedAt(LocalDateTime.now());
        }

        // Calculate totalAmount from items
        double total = order.getItems()
                            .stream()
                            .mapToDouble(item -> item.getQty() * item.getPrice())
                            .sum();
        order.setTotalAmount(total);

        // If status is missing, default to "pending"
        if (order.getStatus() == null || order.getStatus().isEmpty()) {
            order.setStatus("pending");
        }

        return orderRepository.save(order);
    }


    // Get all Orders
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Update Order Status
    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable String id, @RequestParam String status) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        if (orderOpt.isEmpty()) {
            throw new RuntimeException("Order not found");
        }
        Order order = orderOpt.get();
        order.setStatus(status);
        return orderRepository.save(order);
    }

    // Delete Order
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable String id) {
        if (!orderRepository.existsById(id)) {
            return "Order not found";
        }
        orderRepository.deleteById(id);
        return "Order deleted successfully";
    }
}
