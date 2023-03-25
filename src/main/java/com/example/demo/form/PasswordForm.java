package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordForm {
	@NotBlank(message = "必須項目です")
	@Size(min = 6, max = 30, message = "6〜30文字で設定してください")
    private String password;
	
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
