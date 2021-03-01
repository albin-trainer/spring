package com.mycompany.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
public List<Product> findByProductName(String name);
}
