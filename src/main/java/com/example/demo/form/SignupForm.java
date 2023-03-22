package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupForm {
	
	@NotBlank(message = "必須項目です")
	@Size(min = 3, max = 50, message = "3〜50文字で設定してください")
	private String username;
	
	@NotBlank(message = "必須項目です")
	@Size(min = 6, max = 30, message = "6〜30文字で設定してください")
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
