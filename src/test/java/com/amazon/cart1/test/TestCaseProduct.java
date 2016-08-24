package com.amazon.cart1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.ProductDAO;
import com.amazon.cart1.model.Product;

public class TestCaseProduct {

	
	@Autowired
	 ProductDAO ProductDAO;
		@Autowired
		Product Product;
		AnnotationConfigApplicationContext context;
		@Before
		public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.amazon");
			context.refresh();
			 ProductDAO=(ProductDAO) context.getBean("productDAO");
			 Product= (Product) context.getBean("product");
		}
		@Test
		public void deleteProductTestCase()
		{
			Product.setId("101");
			boolean flag = ProductDAO.delete(Product);
			
			assertEquals("deleteProductTestCase ",flag,true);
		}
		
		
		@Test
		public void addProductTestCase()
		{
			Product.setId("PRO_002");
			Product.setName("Electronic");
			Product.setDescription("THIS IS IPHONE");
			Product.setPrice(80000);
			assertEquals("addProductTestCase",ProductDAO.save(Product),true);
		}
		@Test
		public void listProductTestCase()
		{
			
			assertEquals("listProductTestCase", ProductDAO.list().size(),1);
		}
		@Test
		public void updateProductTestCase()
		{
			Product.setId("PRO_002");		
			Product.setName("LENOVO");
			Product.setPrice(80000);
			Product.setDescription("THIS IS LENOVO");
			assertEquals("update Product Test Case ",ProductDAO.update(Product),true);
		}
		
		@Test
		public void getProductTestCase()
		{
			Product = ProductDAO.get("PRO_002");
			assertEquals("getProductTestCase",Product.getId(),"PRO_002");
		}

		
		
		
		
		
		
		
		
		
		
	/*@Test
	public void deleteProductTest(){
		Product.setId("mobile_22");
		Product.setName("lenovo");
		Product.setDescription("latest version");
		Product.setId("101");
		Product.setName("hp");
		Product.setDescription("notepad");
		Product.setPrice(10000);
		boolean flag =ProductDAO.delete(Product);
		assertEquals("deleteProductTest",flag,true);
		
	}
	@Test
	public void addProductTest()

	{
		Product.setId("iPad_25");
		Product.setName("Apple");
		Product.setDescription("this is new iPad");
		
		assertEquals("addProductTest",ProductDAO.save(Product),true);
		
	}
	@Test
	public void listProductTest(){
		assertEquals("listProductTest",ProductDAO.list().size(),1);
	}
	@Test
	public void updateProductTestCase(){
		Product.setId("laptop");
		Product.setName("hp");
		Product.setDescription("ThinkPad");
		assertEquals("updateProductTestCase",ProductDAO.update(Product),true);
		
	}
	@Test
	public void getProductTestCase(){

	assertEquals("getProductTestCase",ProductDAO.get("laptop"),Product);
	}
	
*/
}
