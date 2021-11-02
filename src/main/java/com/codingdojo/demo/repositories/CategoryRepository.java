package com.codingdojo.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.demo.models.Category;
import com.codingdojo.demo.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category>findAll();
	
	List<Category> findByProductsNotContains(Product product);
	
	List<Category> findAllByProducts(Product product);
}
