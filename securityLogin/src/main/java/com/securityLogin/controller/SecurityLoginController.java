package com.securityLogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.securityLogin.dto.UserDto;
import com.securityLogin.service.UserService;

@Controller
public class SecurityLoginController {
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/")
    public String getLogin(Model model) throws Exception {
		UserDto user = UserDto.builder()
				.email("email@email.de")
				.firstname("firstname")
				.lastname("lastname")
				.password("test")
				.build();
		
		userService.saveUser(user);
		
		return "login";
	}
    
    @GetMapping("/user")
    public String getUserPage(Model model) throws Exception {
		return "user";
	}
    
    @GetMapping("/register")
    public String getRegister(Model model) throws Exception {
		return "register";
	}
    
    @PostMapping("/save")
    public String savePost(UserDto userDto) throws Exception {
    	userService.saveUser(userDto);

    	return "/login";
    }
    

}
