package com.example.demo;

import java.util.List;

public interface TodoDao {
	
	List<Todo> findAll();
	void insert(Todo todo);
	int deleteById(int todoId);

}
