package com.codingdojo.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.demo.models.ProductsAndCategories;

public interface ProductsAndCategoriesRepository extends CrudRepository<ProductsAndCategories, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO products_and_categories(product_id,category_id) " +
	"VALUES(?1,?2)", nativeQuery=true)
	public void linkProductAndCategory(int product_id,int category_id);
}
