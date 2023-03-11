package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDaoImpl implements TodoDao {
	
	private final JdbcTemplate jdbcTemplate;

	public TodoDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Todo> findAll() {
		String sql = "SELECT todoId, todo.userId, title, significance, "
				+ "method, barrier, advantage, disadvantage FROM todo "
				+ "INNER JOIN user ON todo.userId = user.userId";

		//todo一覧をMapのListで取得
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

		//return用の空のListを用意
		List<Todo> list = new ArrayList<>();

		//二つのテーブルのデータをTodoにまとめる
		for(Map<String, Object> result : resultList) {

			Todo todo = new Todo();
			todo.setTodoId((Integer)result.get("todoId"));
			todo.setUserId((Integer)result.get("userId"));
			todo.setTitle((String)result.get("title"));
			todo.setSignificance((String)result.get("significance"));
			todo.setMethod((String)result.get("method"));
			todo.setBarrier((String)result.get("barrier"));
			todo.setAdvantage((String)result.get("advantage"));
			todo.setDisadvantage((String)result.get("disadvantage"));
			

			list.add(todo);
		}
		return list;
	}

	@Override
	public void insert(Todo todo) {
		jdbcTemplate.update("INSERT INTO todo(userId, todoId, title, significance, "
				+ "method, barrier, advantage, disadvantage) VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				todo.getUserId(), todo.getTodoId(), todo.getTitle(), todo.getSignificance(),
				todo.getMethod(), todo.getBarrier(), todo.getAdvantage(), todo.getDisadvantage());
		
	}
	
	@Override
	public int deleteById(int todoId) {
		return jdbcTemplate.update("DELETE FROM todo WHERE todoId = ?", todoId);
	}

}
