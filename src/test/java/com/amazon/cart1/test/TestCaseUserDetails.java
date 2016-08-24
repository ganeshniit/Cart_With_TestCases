package com.amazon.cart1.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.UserDetailsDAO;
import com.amazon.cart1.model.UserDetails;

public class TestCaseUserDetails {

	 	
	 @Autowired
	 UserDetailsDAO userDetailsDAO;
		@Autowired
		UserDetails userDetails;
		AnnotationConfigApplicationContext context;
		@Before
		public void init(){
			context=new AnnotationConfigApplicationContext();
			context.scan("com.amazon");
			context.refresh();
		userDetailsDAO=(UserDetailsDAO) context.getBean("userDetailsDAO");
		userDetails= (UserDetails) context.getBean("userDetails");
		}
	@Test
	public void deleteUserDetailsTest(){
		 userDetails.setId("User_22");
		 
		boolean flag =userDetailsDAO.delete(userDetails);
		assertEquals("deleteUserDetailsTest",flag,true);
		
	}
	@Test
	public void addUserDetailsTest()

	{
		 userDetails.setId("User_23");
		 userDetails.setName("Sai");
		 userDetails.setEmail("nitish@gmail.com");
		 userDetails.setPassword("nitishv");
		 userDetails.setContact("8185956671");
		 userDetails.setAddress("Hyderabad");
		//UserDetails.setDescription("this is new iphone");
		
		assertEquals("addUserDetailsTest",userDetailsDAO.save(userDetails),true);
		
	}
	@Test
	public void listUserDetailsTest(){
		assertEquals("listUserDetailsTest",userDetailsDAO.list().size(),1);
	}
	@Test
	public void updateUserDetailsTestCase(){
		 userDetails.setId("User_23");
		 userDetails.setName("Sainitish");
		 userDetails.setEmail("nitish@gmail.com");
		 userDetails.setPassword("nitishv");
		 userDetails.setContact("8185956671");
		 userDetails.setAddress("Hyderabad");
		assertEquals("updateUserDetailsTestCase",userDetailsDAO.update(userDetails),true);
		
	}
	@Test
	public void getUserDetailsTestCase(){
		userDetails = userDetailsDAO.get("User_23");
	assertEquals("getUserDetailsTestCase",userDetails.getName(),"Sainitish");
	
	}
	

}
