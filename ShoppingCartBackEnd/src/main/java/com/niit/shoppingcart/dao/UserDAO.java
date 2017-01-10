package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.UserInfo;

public interface UserDAO {
//validation operation
public boolean	isValidCredentials(String id,String password);
//later add crud operations
public List<UserInfo> list();


//getting user based on id

public     UserInfo get(String id);
//checking the credentials are valid are not
public UserInfo validate(String id,String password);
// save??
public boolean save(UserInfo user);
//update
public boolean Update(UserInfo user);
}



//hve to specify the method to impl in othr cls
//jus to decl wht to do
//crud opr+validation
//method signat
//access_specifier return_typ methodName(parameter_list)