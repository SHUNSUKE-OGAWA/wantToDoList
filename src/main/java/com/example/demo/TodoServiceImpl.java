package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService {
	
	private final TodoDao dao;

	public TodoServiceImpl(TodoDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Todo> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Todo getTodo(int todoId) {
		return dao.findByTodoId(todoId);
	}
	
	@Transactional
	@Override
	public void insert(Todo todo) {
		dao.insert(todo);
	}
	
	@Override
	public void deleteByTodoId(int todoId) {
		dao.deleteByTodoId(todoId);
	}

}
