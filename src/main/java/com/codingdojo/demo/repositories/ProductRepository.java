package com.codingdojo.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.demo.models.Category;
import com.codingdojo.demo.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product>findAll();

	Product findProductById(Long id);

	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
}
