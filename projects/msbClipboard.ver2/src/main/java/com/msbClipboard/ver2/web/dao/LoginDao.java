package com.msbClipboard.ver2.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

@Component
public class LoginDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean check(String uname, String pass) {
		
		return false;
	}

}
