package com.amazon.cart1.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.SupplierDAO;
import com.amazon.cart1.model.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
 context.scan("com.amazon.cart1");
 context.refresh();
 SupplierDAO SupplierDAO =(SupplierDAO) context.getBean("supplierDAO");
 Supplier Supplier =(Supplier) context.getBean("supplier");

 Supplier.setId("CZ");
 Supplier.setName("GANESH");
 Supplier.setDescription("BIG C");

if(SupplierDAO.save(Supplier)==true){
	System.out.println("a");
}
else{
	System.out.println("b");
}
	}

}
