package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
