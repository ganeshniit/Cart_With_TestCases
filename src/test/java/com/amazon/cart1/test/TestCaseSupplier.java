package com.amazon.cart1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.SupplierDAO;
import com.amazon.cart1.model.Supplier;

public class TestCaseSupplier {

	 @Autowired
	 SupplierDAO supplierDAO;
		@Autowired
		Supplier supplier;
		AnnotationConfigApplicationContext context;
		@Before
		public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.amazon");
			context.refresh();
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		supplier= (Supplier) context.getBean("supplier");
		}
	@Test
	public void deleteSupplierTest(){
		supplier.setId("CZ");
		boolean flag =supplierDAO.delete(supplier);
		assertEquals("deleteSupplierTest",flag,true);
		
	}
	@Test
	public void addSupplierTest()

	{
		supplier.setId("mk_2");
		supplier.setName("ganesh");
		supplier.setDescription("this is new iphone");
		
		assertEquals("addSupplierTest",supplierDAO.save(supplier),true);
		
	}
	@Test
	public void listSupplierTest(){
		assertEquals("listSupplierTest",supplierDAO.list().size(),2);
	}
	@Test
	public void updateSupplierTestCase(){
		supplier.setId("mk_2");
		supplier.setName("ganeshv");
		supplier.setDescription("this is new iphone");
		assertEquals("updateSupplierTestCase",supplierDAO.update(supplier),true);
		
	}
	@Test
	public void getSupplierTestCase(){
	/*supplier=supplierDAO.get("mk_2");
	assertEquals("getSupplierTestCase",supplier.getId(),"mk_2");
*/	
	supplier=supplierDAO.get("mk_2");
	assertEquals("getSupplierTestCase", supplier.getId(), "mk_2");
	
	}

	
	
	
	
	/* @Autowired
	 SupplierDAO supplierDAO;
		@Autowired
		Supplier supplier;
		AnnotationConfigApplicationContext context;
		@Before
		public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.amazon");
			context.refresh();
		supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		supplier= (Supplier) context.getBean("supplier");
		}
	@Test
	public void deleteSupplierTest(){
		 supplier.setId("CZ");
		 assertEquals("deleteSupplierTest",supplierDAO.delete(supplier),true);
		
	}
	@Test
	public void addSupplierTest()

	{
		supplier.setId("CQ");
		supplier.setName("MANOJ");
		supplier.setDescription("SANGEETHA");
		
		assertEquals("addSupplierTest",supplierDAO.save(supplier),true);
		
	}
	@Test
	public void listSupplierTest(){
		
		assertEquals("listSupplierTest",supplierDAO.list().size(),1);
	}
	@Test
	public void updateSupplierTestCase(){
		supplier.setId("CQ");
		supplier.setName("Manoj Kumar");
		supplier.setDescription("TMC");
		assertEquals("updateSupplierTestCase",supplierDAO.update(supplier),true);
		
	}
	@Test
	public void getSupplierTestCase(){
		supplier=supplierDAO.get("CQ");
		assertEquals("getSupplierTestCase",supplier.getName(),"Manoj Kumar");
	}
	
*/
}
