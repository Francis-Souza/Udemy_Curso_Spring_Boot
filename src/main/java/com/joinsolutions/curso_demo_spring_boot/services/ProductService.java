package com.joinsolutions.curso_demo_spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot.entities.Product;
import com.joinsolutions.curso_demo_spring_boot.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> finAll(){
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
	

}
