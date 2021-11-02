package com.codingdojo.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.demo.models.Category;
import com.codingdojo.demo.models.Product;
import com.codingdojo.demo.repositories.CategoryRepository;
import com.codingdojo.demo.repositories.ProductRepository;
import com.codingdojo.demo.repositories.ProductsAndCategoriesRepository;

@Service
public class AppService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	private final ProductsAndCategoriesRepository panRepo;
	
	public AppService( ProductRepository productRepo, CategoryRepository categoryRepo, ProductsAndCategoriesRepository panRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.panRepo = panRepo;
	}
	
	public Product createProduct(Product product) {
		return this.productRepo.save(product);
	}
	
	
	public Product findProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public List<Product> findAllCategories(Category category){
		return productRepo.findAllByCategories(category);
	}
	
	public List<Product> findProductsNotInCategory(Category category){
		return productRepo.findByCategoriesNotContains(category);
	}
	
	
	public Category createCategory(Category category) {
		return this.categoryRepo.save(category);
	}
	
	public List<Category> findCategoriesNotInProduct(Product product){
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public List<Category> findAllProducts(Product product){
		return categoryRepo.findAllByProducts(product);
	}
	
	
	public void linkProductsAndCategories(int product, int category) {
		panRepo.linkProductAndCategory(product, category);
	}

	public Category findCategoryById(Long id) {
		return categoryRepo.findById(id).orElse(null);
	}
	
	
}
