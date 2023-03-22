package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Todo;

public interface TodoDao {
	
	List<Todo> findAll();
	Todo findByTodoId(int todoId);
	void insert(Todo todo);
	int update(Todo todo);
	int deleteByTodoId(int todoId);

}
