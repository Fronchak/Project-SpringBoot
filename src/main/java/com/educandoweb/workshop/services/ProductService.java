package com.educandoweb.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.workshop.entities.Product;
import com.educandoweb.workshop.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRespository;
	
	public List<Product> findAll() {
		return productRespository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> product = productRespository.findById(id);
		return product.get();
	}
}
