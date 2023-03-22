package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TodoDao;
import com.example.demo.entity.Todo;

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
	public void update(Todo todo) {
		dao.update(todo);
	}
	
	@Override
	public void deleteByTodoId(int todoId) {
		dao.deleteByTodoId(todoId);
	}

}
