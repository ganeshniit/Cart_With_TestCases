package com.amazon.cart1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.ProductDAO;
import com.amazon.cart1.model.Product;

public class TestCaseProduct1 {

	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com.cart1");
		context.refresh();
	productDAO=(ProductDAO) context.getBean("ProductDAO");
	product= (Product) context.getBean("Product");
	}
	@Test
	public void deleteProductTestCase(){
		product.setId("101");
		boolean flag =productDAO.delete(product);
		assertEquals("deleteProductTestCase",flag,true);
		
	}
	@Test
	public void addProductTestCase()
	
	{
		product.setId("MOB_002");
		product.setName("i-phone6");
		product.setDescription("this is new iphone");
		product.setPrice(60000);
		assertEquals("addProductTestCase",productDAO.save(product),true);
		
	}
	@Test
	public void listProductTestCase(){
		assertEquals("listProductTestCase",productDAO.list().size(),2);
		
	}
	@Test
	public void updateProductTestCase(){
		product.setId("MOB_002");
		product.setName("i-phone6");
		product.setDescription("this is refurbished iphone");
		product.setPrice(68000);
		assertEquals("updateProductTestCase",productDAO.update(product),true);
		
	}
	@Test
	public void getProductTestCase()
	{
		product=productDAO.get("MOB_002");
	assertEquals("getProductTestCase",product.getId(),"MOB_002");
	}

	}


