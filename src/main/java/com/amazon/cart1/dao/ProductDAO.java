package com.amazon.cart1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.amazon.cart1.model.Product;

@Repository

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public Product get(String id);
    public List<Product> list();

}


