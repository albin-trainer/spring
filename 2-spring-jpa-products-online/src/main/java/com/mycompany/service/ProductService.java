package com.mycompany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.domain.Product;
import com.mycompany.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
private ProductRepository repository;
	
	public Product saveProduct(Product p) {
		repository.save(p);
		return p;
	}
	public List<Product> getAllProducts(){
		List<Product> productList=new ArrayList<Product>();
		repository.findAll().forEach(productList::add);
		return productList;
	}
	
	public Product getProductById(int id) {
	return	repository.findById(id).get();
	}
	
	public List<Product> getProductByProductName(String pname) {
		return	repository.findByProductName(pname);
		}
}
