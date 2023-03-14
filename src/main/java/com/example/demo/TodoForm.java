package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TodoForm {
	
	private int userId;
	
	@NotBlank(message = "必須項目です")
	@Size(max = 500, message = "500文字以内にしてください")
	private String title;
	
	@NotBlank(message = "必須項目です")
	@Size(max = 500, message = "500文字以内にしてください")
	private String significance;
	
	@NotBlank(message = "必須項目です")
	@Size(max = 500, message = "500文字以内にしてください")
	private String method;
	
	@NotBlank(message = "必須項目です")
	@Size(max = 500, message = "500文字以内にしてください")
	private String barrier;
	
	@NotBlank(message = "必須項目です")
	@Size(max = 500, message = "500文字以内にしてください")
	private String advantage;
	
	@NotBlank(message = "必須項目です")
	@Size(max = 500, message = "500文字以内にしてください")
	private String disadvantage;
	
	public TodoForm() {}
	
	public TodoForm(int userId, 
			String title,
			String significance, 
			String method, 
			String barrier, 
			String advantage, 
			String disadvantage) {
		
		this.userId = userId;
		this.title = title;
		this.significance = significance;
		this.method = method;
		this.barrier = barrier;
		this.advantage = advantage;
		this.disadvantage = disadvantage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	

}
