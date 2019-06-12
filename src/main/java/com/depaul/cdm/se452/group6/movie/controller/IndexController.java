package com.depaul.cdm.se452.group6.movie.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.depaul.cdm.se452.group6.movie.entity.User;
import com.depaul.cdm.se452.group6.movie.entity.UserLogin;
import com.depaul.cdm.se452.group6.movie.service.UserLoginService;
import com.depaul.cdm.se452.group6.movie.service.UserService;

@Controller
public class IndexController {
	private UserLoginService userLoginService;
	private UserService userService;
	
	public IndexController(UserLoginService userLoginService
			, UserService userService) {
		this.userLoginService = userLoginService;
		this.userService = userService;
	}
	
	@GetMapping("/")
    public String root(Model model) {
		userLoginService.loginSuccess(1L, "admin", "1234");
		model.addAttribute("userLogin", new UserLogin());
		model.addAttribute("newUser", new User());
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
	
	@PostMapping("/register")
	public String saveRegister(@ModelAttribute("newUser") User user,
			@ModelAttribute("userLogin") UserLogin userLogin) {
		String fname = user.getFirstname();
		String lname = user.getLastname();
		String email = user.getEmail();
		String phonenum = user.getPhoneNumber();
		String dob = user.getDateOfBirth();
		String username = userLogin.getUserName();
		String password = userLogin.getPassword();
//		String usertype = user.getUsertype().getType();
		
		userService.getUsers().add(user);
		userLoginService.loginSuccess(2L, username, password);
		
		System.out.println("------- username: " + username);
		System.out.println("------- password: " + password);
		System.out.println("------- name: " + fname);
		System.out.println("------- lname: " + lname);
		System.out.println("------- email: " + email);
		System.out.println("------- phone: " + phonenum);
		System.out.println("------- DOB: " + dob);

		return "redirect:/profile";
	}

}
