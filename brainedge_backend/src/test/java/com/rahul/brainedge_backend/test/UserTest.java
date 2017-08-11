package com.rahul.brainedge_backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;

import com.rahul.brainedge_backend.entity.User;
import com.rahul.brainedge_backend.service.UserService;

public class UserTest {
	
	private static AnnotationConfigApplicationContext context;
	private static UserService userService;
	private User user;
	
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.rahul.brainedge_backend");
		context.refresh();
		
		userService=(UserService)context.getBean("userService");
	}
	
	@Test
	public void testSave() {
		user=new User();
		user.setFirstName("Rahul");
        user.setLastName("Raj");
        user.setEmail("rajrahul9939@gmail.com");
        user.setPassword("2@rahulraj");
        
        assertEquals("failed to save", true, userService.save(user));
	}
}
