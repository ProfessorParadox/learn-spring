  package com.msb.msbclipboardAlpha.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.msb.msbclipboardAlpha.models.User;
import com.msb.msbclipboardAlpha.models.UserPrincipal;
import com.msb.msbclipboardAlpha.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User 404! Please Register!");
		return new UserPrincipal(user);
	}

}
