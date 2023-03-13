package com.example.demo;

import java.util.List;

public interface TodoService {
	List<Todo> findAll();
	Todo getTodo(int todoId);
	void insert(Todo todo);
	void update(Todo todo);
	void deleteByTodoId(int todoId);
}
