package com.example.demo;

public class TodoForm {
	
	private int userId;
	private String significance, method, barrier, advantage, disadvantage;
	private boolean newTodo;
	
	public TodoForm() {}
	
	public TodoForm(int userId, 
			String significance, 
			String method, 
			String barrier, 
			String advantage, 
			String disadvantage, 
			boolean newTodo) {
		
		this.userId = userId;
		this.significance = significance;
		this.method = method;
		this.barrier = barrier;
		this.advantage = advantage;
		this.disadvantage = disadvantage;
		this.newTodo = newTodo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSignificance() {
		return significance;
	}

	public void setSignificance(String significance) {
		this.significance = significance;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getBarrier() {
		return barrier;
	}

	public void setBarrier(String barrier) {
		this.barrier = barrier;
	}

	public String getAdvantage() {
		return advantage;
	}

	public void setAdvantage(String advantage) {
		this.advantage = advantage;
	}

	public String getDisadvantage() {
		return disadvantage;
	}

	public void setDisadvantage(String disadvantage) {
		this.disadvantage = disadvantage;
	}

	public boolean isNewTodo() {
		return newTodo;
	}

	public void setNewTodo(boolean newTodo) {
		this.newTodo = newTodo;
	}
	
	

}
