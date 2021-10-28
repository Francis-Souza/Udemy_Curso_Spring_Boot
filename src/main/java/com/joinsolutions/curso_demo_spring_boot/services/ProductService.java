package com.joinsolutions.curso_demo_spring_boot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot.entities.Product;
import com.joinsolutions.curso_demo_spring_boot.repositories.ProductRepository;
import com.joinsolutions.curso_demo_spring_boot.services.exceptions.DatabaseException;
import com.joinsolutions.curso_demo_spring_boot.services.exceptions.ResourceNotFoundException;

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
	
	public Product insert(Product obj) {
		return productRepository.save(obj);
	}
	
	public void deleteById(Long id) {
		try {
			productRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}	
	
	@SuppressWarnings("deprecation")
	public Product update(Long id, Product obj) {
		try {			
			Product product = productRepository.getOne(id);
			updateData(product, obj);
			return productRepository.save(obj);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product product, Product obj) {
		
		product.setName(obj.getName());
		product.setDescription(obj.getDescription());
		product.setPrice(obj.getPrice());
		product.setImgUrl(obj.getImgUrl());
		
	}

}
