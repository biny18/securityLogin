package com.securityLogin.controller;

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
    
    @PostMapping("/registerUser")
    public String registerUser(UserDto userDto) throws Exception {
    	userService.saveUser(userDto);

    	return "redirect:/";
    }
    

}
