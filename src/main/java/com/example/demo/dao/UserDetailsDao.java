package com.example.demo.dao;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsDao {
	
	UserDetails findNameByUser(String username);
	
	void insertUser(String username, String password, String authority);
	
	int findUserCountByUser(String username);
	
	public int findUserIdByUser(String username);
	
	void updatePassword(String username, String password);

}
