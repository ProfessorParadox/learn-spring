package com.msbClipboard.ver2.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;
	private String email;
	private String uname;
	private String pass;
	
	public User(String email, String uname, String pass) {
		super();
		this.email = email;
		this.uname = uname;
		this.pass = pass;
	}

	public int getUserID() {
		return userID;
	}

	public String getEmail() {
		return email;
	}

	public String getUname() {
		return uname;
	}

	public String getPass() {
		return pass;
	}
		

}
