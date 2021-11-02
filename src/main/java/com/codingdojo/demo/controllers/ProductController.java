package com.codingdojo.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.demo.models.Category;
import com.codingdojo.demo.models.Product;
import com.codingdojo.demo.services.AppService;

@Controller
public class ProductController {
	private final AppService appService;
	public ProductController(AppService service) {
		appService = service;
	}
	
	@RequestMapping("/products/new")
	public String Index() {
		return "newproduct.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String AddProduct(@RequestParam(value="product")String name,
							 @RequestParam("description")String description,
							 @RequestParam("price")double price) {
		Product product = new Product(name, description, price);
		appService.createProduct(product);
		return "redirect:/new";
	}
	
	@RequestMapping(value="/products/{id}")
	public String ShowProduct(@PathVariable("id")Long id, Model model) {
		Product product = appService.findProductById(id);
		List<Category> different = appService.findCategoriesNotInProduct(product);
		List<Category> present = appService.findAllProducts(product);
		model.addAttribute("product",product);
		model.addAttribute("different", different);
		model.addAttribute("present",present);
		System.out.println(present.get(0).getName());
		return "displayproduct.jsp";
	}
	
	@RequestMapping(value="/add/product/category/{id}", method=RequestMethod.POST)
	public String addCategoryToProduct(@PathVariable("id")int product_id,
									   @RequestParam(value="category")int category_id) {
		System.out.print("product id: "+ product_id);
		System.out.print("Category id: "+category_id);
		System.out.print("F");
		appService.linkProductsAndCategories(product_id, category_id);
		return "redirect:/products/" + product_id;
	}
	
}
