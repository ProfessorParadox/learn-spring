package com.msb.msbclipboardAlpha;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findbyUsername(String username);
}
