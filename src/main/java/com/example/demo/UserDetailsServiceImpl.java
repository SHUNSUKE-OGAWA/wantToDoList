package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDetailsDao userDetailsDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
            return userDetailsDao.findNameByUser(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user not found.", e);
        }
    }
	
	@Transactional
    public void register(String username, String password, String authority) {
        userDetailsDao.insertUser(username, password, authority);
    }
	
	public boolean isExistUser(String username) {
        if (userDetailsDao.findUserCountByUser(username) == 0) {
            return false;
        }
        return true;
    }

}
