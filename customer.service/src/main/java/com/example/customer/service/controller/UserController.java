package com.example.customer.service.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.customer.service.repository.UserRepository;
import com.example.customer.service.model.User;


@RestController
@RequestMapping("/users")


public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		
		Optional<User> findproduct=userRepository.findById(id);
		if(findproduct.isEmpty()) {
			log.error("Failed to delete product"+id);
			return "Failed to delete product";
		}
		userRepository.deleteById(id);
		log.info("Product Deleted"+id);
		return "Product Deleted";
		
	}
	

}