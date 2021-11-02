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
public class CategoryController {
	private final AppService appService;
	public CategoryController(AppService service) {
		appService = service;
	}
	
	@RequestMapping(value="/category/new")
	public String CreateIndex() {
		return "newcategory.jsp";
	}
	
	@RequestMapping(value="/add/category", method=RequestMethod.POST)
	public String CreateCategory(@RequestParam(value="name")String name) {
		Category category = new Category(name);
		appService.createCategory(category);
		return "redirect:/category/new";
	}
	
	@RequestMapping(value="categories/{id}")
	public String displayCategory(@PathVariable("id")Long id, Model model) {
		Category category = appService.findCategoryById(id);
		List<Product> present = appService.findAllCategories(category);
		List<Product> different = appService.findProductsNotInCategory(category);
		model.addAttribute("present",present);
		model.addAttribute("category",category);
		model.addAttribute("different", different);		
		return"displaycategory.jsp";
	}
	
	
	@RequestMapping(value="/add/category/product/{id}", method=RequestMethod.POST)
	public String addProductToCategory(@PathVariable("id")int category_id,
									   @RequestParam(value="product")int product_id) {
		System.out.print("product id: "+ product_id);
		System.out.print("Category id: "+category_id);
		System.out.print("F");
		appService.linkProductsAndCategories(product_id, category_id);
		return "redirect:/categories/" + category_id;
	}

}
