package com.depaul.cdm.se452.group6.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.depaul.cdm.se452.group6.movie.entity.UserLogin;
import com.depaul.cdm.se452.group6.movie.service.UserLoginService;

@Controller
public class IndexController {
	private UserLoginService userLoginService;
	
	public IndexController(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
	
	@GetMapping("/")
    public String root(Model model) {
		userLoginService.loginSuccess(1L, "admin", "1234");
		model.addAttribute("userLogin", new UserLogin());
        return "index";
    }
	
	
	@PostMapping("/login")
	public String saveUserLogin(@ModelAttribute("userLogin") UserLogin userLogin) {		
		String userInput = userLogin.getUserName();
		String passInput = userLogin.getPassword();
		System.out.println("NAME: " + userInput);
		System.out.println("PASS: " + passInput);
		
		if (userLoginService.findByUserLoginName(userInput).isEmpty()) {
			return "redirect:/";
			
		} else if (userLoginService.findByUserLoginName(userInput)
				.get(0).getPassword().equals(passInput)) {
			return "redirect:/profile";	
		} 
		
		return "redirect:/";
		
	}

}
