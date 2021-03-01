package com.mycompany.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.domain.Product;
import com.mycompany.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private	ProductService service;
	@RequestMapping("/test")
	public String test() {
		return "test success";
	}
	@PostMapping
public Product addNewProduct(@RequestBody Product p) {
		System.out.println("saving in db..");
	return service.saveProduct(p);
}
	@GetMapping
public List<Product> getAllProducts(){
	return service.getAllProducts();
	
}
	@GetMapping("/{pid}")
	public Product readById( @PathVariable("pid") int id) {
		System.out.println("finding ----->"+id);
		return service.getProductById(id);
	}
	@GetMapping("pname/{pname}")
	public List<Product> readProductByProductName(@PathVariable String pname) {
		return service.getProductByProductName(pname);
	}
	
}
