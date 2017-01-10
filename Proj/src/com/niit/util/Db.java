package com.niit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {
public static void main(String[] a) throws SQLException,ClassNotFoundException{

	Class.forName("org.h2.Driver");
	String ins=("insert into t1 values(101,'celina')");
	Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","sa");
	Statement st=con.createStatement();
	
}
}