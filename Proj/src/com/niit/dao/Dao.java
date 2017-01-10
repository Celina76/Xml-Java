package com.niit.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.tomcat.jni.User;

import java.util.ArrayList;

import com.niit.util.Db;



public class Dao {
	private Connection con;
	public UserDao()
	{
		con=Db.getConnection();
		
	}
	public void addUser(User user)
	{
		try
		{
			PreparedStatement preparedStatement=connection.preparedStatement("insert into users(StudId,Name)values(?,?)");
			preparedStatement.setString(1,user.getStudId());
			preparedStatement.setString(2,user.getName());
	
			preparedStatement.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void updateUser(User user)
	{
		try
		{
			PreparedStatement preparedStatement=connection.preparedStatement("update users set StudId=?,Name=?,"+"where StudId=?");
			preparedStatement.setString(1,user.getStudId());
			preparedStatement.setString(2,user.getName());
	
			preparedStatement.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}}
	public List<User> getAllUser()
	{
		List<User> getAlluser()
		{
			List<User> user=new ArrayList<User>();
			try{
				Statement st=con.createStatement();
				ResultSet rs=statement.executeQuery("select*from user");
				while(rs.next()){
					user.setUserid(rs.getInt("StudId"));
					user.setName(rs.getString("Name"));
			
					user.add(user);
					
				}
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
		
	return user;
	}
	public User getUserById(int studId)
	{
		User user=new User();
		try{
			PreparedStatement preparedstatement=con.PreparedStatement("select*from users where userid=?");
			preparedstatement.setInt(1,studId);
			ResultSet rs=preparedstatement.executeQuery();
			if(rs.next())
			{
				user.setUserId(rs.getInt("studId"));
				user.setName(rs.getString("name"));
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return user;
			
		}
	}
	
	
	
	
}