package com.amazon.cart1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.CategoryDAO;
import com.amazon.cart1.model.Category;

public class TestCaseCategory {

	
	 @Autowired
	 CategoryDAO categoryDAO;
		@Autowired
		Category category;
		AnnotationConfigApplicationContext context;
		@Before
		public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.amazon");
			context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		category= (Category) context.getBean("category");
		}
@Test
	public void deleteCategoryTest(){
		 category.setId("155");
		 
		//boolean flag =categoryDAO.delete(category);
		assertEquals("deleteCategoryTest",categoryDAO.delete(category),true);
		
	}
	@Test
	public void addCategoryTest()

	{
		category.setId("156");
		category.setName("Mens");
		category.setDescription("Clothing");
		
		assertEquals("addCategoryTest",categoryDAO.save(category),true);
		
	}
	@Test
	public void listCategoryTest(){
		
		assertEquals("listCategoryTest",categoryDAO.list().size(),2);
	}
	@Test
	public void updateCategoryTestCase(){
		category.setId("156");
		category.setName("Women");
		category.setDescription("Clothings");
		assertEquals("updateCategoryTestCase",categoryDAO.update(category),true);
		
	}
	@Test
	public void getCategoryTestCase(){
		category = categoryDAO.get("155");
	assertEquals("getCategoryTestCase",category.getId(),"155");
	
	}
	

}
