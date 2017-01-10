package com.niit.shoppingcart.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class UserInfo {
	private String username;
	private String password;
	private String mail;
	private String contact;
	private String role;
//map to specficic db entity(tab)
	//which tab yu hve map
	//create singleton inst/obj
	
	
	@Id//to specify this field is primary 
	//@G

	public String getId() {
		return username;
	}
	public void setId(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
