package com.msb.msbclipboardAlpha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msb.msbclipboardAlpha.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
