package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
    	//パスワードをハッシュ関数によって暗号化するやーつ
        return new BCryptPasswordEncoder();
    }
    

    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers("/css/**");
    }

    
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	//認証の設定を記述する
    	http.formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
        ).authorizeHttpRequests(authz -> authz
                .anyRequest().authenticated()
        );
    			
        return http.build();
    }
}