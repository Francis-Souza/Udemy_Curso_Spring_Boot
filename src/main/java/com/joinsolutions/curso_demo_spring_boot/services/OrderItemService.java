package com.joinsolutions.curso_demo_spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot.entities.OrderItem;
import com.joinsolutions.curso_demo_spring_boot.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<OrderItem> findAll() {
		return orderItemRepository.findAll();
	}

	public OrderItem findById(Long id) {
		Optional<OrderItem> obj = orderItemRepository.findById(id);
		return obj.get();
	}

}
