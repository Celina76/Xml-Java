package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.UserInfo;

import junit.framework.Assert;

public class UserDAOTestCase {
	@Autowired
	UserDAO userDao;
	
	@Autowired
	UserInfo user;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	//previously we wrriten constructor
	//but in junit we need to write a method
	//this method shld call when junit test case run automatically
	
	public void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		user=(UserInfo) context.getBean("userInfo");
		userDao=(UserDAO) context.getBean("userDAOImpl");
	}
	
@Test
public void getUserTestCase()
{
	
	
	user=userDao.get("niit");
	//assert stmt
	Assert.assertEquals("User Test Case", "niit",user.getName());
}
}
