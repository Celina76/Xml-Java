package com.niit.shoppingcart.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.UserInfo;
@Repository
public class UserDAOImpl implements UserDAO{

//required session factory-applc context config
	@Autowired
	private SessionFactory sessionFactory;
	//how to get intialize
	//at the time of creation of instance ,yu hva pass session factory
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean isValidCredentials(String id, String password) {
//need to test against db
		//temp id:niit and password:niit@123
		System.out.println("in backend");
		if (id.equals("niit") &&password.equals("123"))
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<UserInfo> list() {
	String hql="from User";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();

	}

	@Override
	@Transactional
	public UserInfo get(String username) {
		
		return (UserInfo)sessionFactory.getCurrentSession().get(UserInfo.class, username);
	}

	@Override
	public UserInfo validate(String username, String password) {
		// select * from user id=niit,passwrd=123
	
		{
			String hql="from user where username='"+username+"'and password='"+password+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);	
			return(UserInfo) query.uniqueResult();
		}
	}

	@Override
	public boolean save(UserInfo user) {
		try
		{
	sessionFactory.getCurrentSession().save(user);}
		catch(Exception e)
		{
			e.printStackTrace();;
		
	}
		return false;}

	public boolean Update(UserInfo user) {
		// TODO Auto-generated method stub
		try{
		sessionFactory.getCurrentSession().update(user);}
		catch(Exception e)
		{
			e.printStackTrace();
		
	}
		return false;}
}