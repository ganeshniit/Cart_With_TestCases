package com.amazon.cart1.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.CategoryDAO;
import com.amazon.cart1.model.Category;

public class TestCaseCategory1 {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.amazon");
		context.scan();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category=(Category)context.getBean("category");
		
	}
	
	@Test
	public void categoryListTestCase()
	{
		List<Category> list=categoryDAO.list();
		int rowCount=list.size();
		assertEquals("category list test case", rowCount, 5);
	}
	@Test
	public void categoryAddTestCase()
	{
		category.setId("CAT_1");
		category.setName("Electronics");
		category.setDescription("GADGETS");
	}
	@Test
	public void categoryTestCase()
	{
		category=categoryDAO.get("CG001");
		System.out.println(category.getDescription());
		System.out.println(category.getName());
		assertEquals(category.getName(), "CAT_1");
		
	}

}
