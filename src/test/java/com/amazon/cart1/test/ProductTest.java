package com.amazon.cart1.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.ProductDAO;
import com.amazon.cart1.model.Product;


public class ProductTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
 context.scan("com.amazon.cart1");
 context.refresh();
 ProductDAO ProductDAO =(ProductDAO) context.getBean("productDAO");
 Product Product =(Product) context.getBean("product");

Product.setId("101");
Product.setName("hp");
Product.setDescription("notepad");
Product.setPrice(10000);
if(ProductDAO.save(Product)==true){
	System.out.println("a");
}
else{
	System.out.println("b");
}
	}

}
