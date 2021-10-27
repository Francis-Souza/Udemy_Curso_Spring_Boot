package com.joinsolutions.curso_demo_spring_boot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot.entities.Category;
import com.joinsolutions.curso_demo_spring_boot.repositories.CategoryRepository;
import com.joinsolutions.curso_demo_spring_boot.services.exceptions.DatabaseException;
import com.joinsolutions.curso_demo_spring_boot.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.get();
	}

	public Category insert(Category obj) {
		return categoryRepository.save(obj);
	}

	public void deleteById(Long id) {
		try {
			categoryRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public Category update(Long id, Category obj) {
		try {
			Category category = categoryRepository.getOne(id);
			updateData(category, obj);
			return categoryRepository.save(category);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Category category, Category obj) {
		category.setName(obj.getName());
	}

}
