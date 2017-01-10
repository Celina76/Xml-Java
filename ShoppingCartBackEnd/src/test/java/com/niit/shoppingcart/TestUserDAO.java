package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.UserInfo;

public class TestUserDAO {
	@Autowired
	UserDAO userDAO;

	@Autowired
	UserInfo user;
	
	@Autowired
	AnnotationConfigWebApplicationContext context;
	
	public TestUserDAO(){
context=new AnnotationConfigWebApplicationContext();
//specify whch pckg u defined the cls
context.scan("com.niit");
context.refresh();
//context->bean factory
//ask context to get the instance 
userDAO=(UserDAO) context.getBean("userDAO");
user=(UserInfo)context.getBean("UserInfo");
}
	public boolean validate(String username,String password)
	{
	if	(userDAO.validate(username, password)==null)
	{
		System.out.println("user does not exit");
		return false;
		
	}
	else
	{
		System.out.println("user is exist");
		return true;
		
	}
	
public static void main(String[] a)
	{
		TestUserDAO t=new TestUserDAO();
				t.validate("niit", "123");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
}
