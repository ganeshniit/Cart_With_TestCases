package com.amazon.cart1.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.cart1.dao.UserDetailsDAO;
import com.amazon.cart1.model.UserDetails;

public class UserDetailsTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
 context.scan("com.amazon");
 context.refresh();
 UserDetailsDAO UserDetailsDAO =(UserDetailsDAO) context.getBean("userDetailsDAO");
 UserDetails UserDetails =(UserDetails) context.getBean("userDetails");

 UserDetails.setId("User_22");
 UserDetails.setName("Ganesh");
 UserDetails.setEmail("vemuriganeshg@gmail.com");
 UserDetails.setPassword("ganeshv");
 UserDetails.setContact("8185956671");
 UserDetails.setAddress("Hyderabad");
if(UserDetailsDAO.save(UserDetails)==true){
	System.out.println("a");
}
else{
	System.out.println("b");
}
	}

}

	

