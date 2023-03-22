package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Todo;

public interface TodoService {
	List<Todo> findAll();
	Todo getTodo(int todoId);
	void insert(Todo todo);
	void update(Todo todo);
	void deleteByTodoId(int todoId);
}
