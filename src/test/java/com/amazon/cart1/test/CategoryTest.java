package com.amazon.cart1.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.CategoryDAO;
import com.amazon.cart1.model.Category;

public class CategoryTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
 context.scan("com.amazon");
 context.refresh();
 CategoryDAO CategoryDAO =(CategoryDAO) context.getBean("categoryDAO");
 Category Category =(Category) context.getBean("category");

 Category.setId("101");
 Category.setName("Electronics");
 Category.setDescription("Gadgets");
 
if(CategoryDAO.save(Category)==true){
	System.out.println("a");
}
else{
	System.out.println("b");
}
	}




}
