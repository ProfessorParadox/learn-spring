package com.msb.msbclipboardAlpha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

//	//local in-memory method for spring security user login
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		
//		//local in-memory method
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder()
//					.username("professor")
//					.password("paradox")
//					.roles("USER")
//					.build()
//					);
//		return new InMemoryUserDetailsManager(users);
//	}
	
	

}
