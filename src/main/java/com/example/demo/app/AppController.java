package com.example.demo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.SignupForm;
import com.example.demo.Todo;
import com.example.demo.TodoForm;
import com.example.demo.TodoServiceImpl;
import com.example.demo.UserDetailsServiceImpl;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private TodoServiceImpl todoServiceImpl;
	
	@GetMapping()
	public String mypage(Model model) {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		model.addAttribute("userId", userDetailsServiceImpl.getUserId(authentication.getName()));
		
		List<Todo> list = todoServiceImpl.findAll();
		model.addAttribute("list", list);
		
		return "mypage";
	}
	
	@GetMapping("/index")
    public String index() {
    	return "index";
    }
	
	@GetMapping("/login")
    public String login() {
    	return "login";
    }
	
	@GetMapping("/signup")
    public String newSignup(SignupForm signupForm) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Validated SignupForm signupForm, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "signup";
    	}
    	
    	if (userDetailsServiceImpl.isExistUser(signupForm.getUsername())) {
            model.addAttribute("signupError", "ユーザー名 " + signupForm.getUsername() + "は既に登録されています");
            return "signup";
        }
    	
        try {
            userDetailsServiceImpl.register(signupForm.getUsername(), signupForm.getPassword(), "ROLE_USER");
        } catch (DataAccessException e) {
            model.addAttribute("signupError", "ユーザー登録に失敗しました");
            return "signup";
        }
        return "redirect:/";
    }
    
    @PostMapping("/insert")
    public String insert(TodoForm todoForm, Model model) {
    	SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		
    	Todo todo = new Todo();
    	todo.setUserId(userDetailsServiceImpl.getUserId(authentication.getName()));
    	todo.setTitle(todoForm.getTitle());
    	todo.setSignificance(todoForm.getSignificance());
    	todo.setMethod(todoForm.getMethod());
    	todo.setBarrier(todoForm.getBarrier());
    	todo.setAdvantage(todoForm.getAdvantage());
    	todo.setDisadvantage(todoForm.getDisadvantage());
    	todoServiceImpl.insert(todo);
    	
    	return "redirect:/";
        
    }
    
    @PostMapping("/delete")
    public String delete(@RequestParam("todoId") int todoId) {
    	//タスクを一件削除しリダイレクト
    	todoServiceImpl.deleteByTodoId(todoId);

        return "redirect:/";
    }
    
    @GetMapping("/create")
    public String create(TodoForm todoForm) {
    	return "createTodo";
    }
    
    @PostMapping("/check")
    public String check(@RequestParam("todoId") int todoId, Model model) {
    	Todo todo = todoServiceImpl.getTodo(todoId);
    	TodoForm todoForm = new TodoForm();
    	
    	todoForm.setUserId(todo.getUserId());
    	todoForm.setTitle(todo.getTitle());
    	todoForm.setSignificance(todo.getSignificance());
    	todoForm.setMethod(todo.getMethod());
    	todoForm.setBarrier(todo.getBarrier());
    	todoForm.setAdvantage(todo.getAdvantage());
    	todoForm.setDisadvantage(todo.getDisadvantage());
    	
    	model.addAttribute("todoForm", todoForm);
    	
    	return "checkTodo";
    }
    
    
}
