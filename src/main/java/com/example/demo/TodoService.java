package com.example.demo;

import java.util.List;

public interface TodoService {
	List<Todo> findAll();
	void insert(Todo todo);
}
