package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetaisDaoImpl implements UserDetailsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails findNameByUser(String username) {
		String sql = "SELECT * FROM user WHERE name = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, username);
        String password = (String)map.get("password");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority((String)map.get("authority")));
        return new UserDetailsImpl(username, password, authorities);
	}

	@Override
	public void insertUser(String username, String password, String authority) {
		String sql = "INSERT INTO user(name, password, authority) VALUES(?, ?, ?)";
        jdbcTemplate.update(sql, username, passwordEncoder.encode(password), authority);
	}

	@Override
	public int findUserCountByUser(String username) {
		String sql = "SELECT COUNT(*) FROM user WHERE name = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] { username });
        return count;
	}

}
