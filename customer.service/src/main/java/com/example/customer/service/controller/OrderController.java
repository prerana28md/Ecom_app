//package com.example.customer.service.controller;
//import java.util.List;
//import java.util.Optional;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.example.customer.service.repository.OrderRepository;
//import com.example.customer.service.model.Order;
//
//
//@RestController
//@RequestMapping("/orders")
//public class OrderController {
//	
//	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
//	@Autowired
//	private OrderRepository orderRepository;
//	
//	@PostMapping
//	public Order createOrder(@RequestBody Order order) {
//		return orderRepository.save(order);
//	}
//	
//	@GetMapping
//	public List<Order> getAllOrders(){
//		return productRepository.findAll();
//	}
//	@DeleteMapping("/{id}")
//	public String deleteProduct(@PathVariable String id) {
//		
//		Optional<Product> findproduct=productRepository.findById(id);
//		if(findproduct.isEmpty()) {
//			log.error("Failed to delete product"+id);
//			return "Failed to delete product";
//		}
//		productRepository.deleteById(id);
//		log.info("Product Deleted"+id);
//		return "Product Deleted";
//		
//	}
//	
//
//}