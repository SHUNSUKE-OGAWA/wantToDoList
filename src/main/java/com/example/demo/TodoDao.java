package com.example.demo;

import java.util.List;

public interface TodoDao {
	
	List<Todo> findAll();
	Todo findByTodoId(int todoId);
	void insert(Todo todo);
	int deleteByTodoId(int todoId);

}
