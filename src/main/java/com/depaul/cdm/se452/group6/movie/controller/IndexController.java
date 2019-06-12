package com.depaul.cdm.se452.group6.movie.controller;
import com.depaul.cdm.se452.group6.movie.entity.Cart;
import com.depaul.cdm.se452.group6.movie.entity.UserType;
import com.depaul.cdm.se452.group6.movie.finder.CartRepository;
import com.depaul.cdm.se452.group6.movie.finder.UserRepository;
import com.depaul.cdm.se452.group6.movie.finder.UserTypeRepository;
import com.depaul.cdm.se452.group6.movie.model.NewUser;
import com.depaul.cdm.se452.group6.movie.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.depaul.cdm.se452.group6.movie.entity.User;
import com.depaul.cdm.se452.group6.movie.entity.UserLogin;
import com.depaul.cdm.se452.group6.movie.service.UserLoginService;
import com.depaul.cdm.se452.group6.movie.service.UserService;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class IndexController {
	private UserLoginService userLoginService;
	private UserService userService;
	private UserRepository userRepository;
	private UserTypeRepository userTypeRepository;
	private CartService cartService;
	private CartRepository cartRepository;
	
	public IndexController(UserLoginService userLoginService
			, UserService userService, UserRepository userRepository, UserTypeRepository userTypeRepository,
												 CartRepository cartRepository) {
		this.userLoginService = userLoginService;
		this.userService = userService;
		this.userRepository = userRepository;
		this.userTypeRepository = userTypeRepository;
		this.cartRepository = cartRepository;
	}
	
	@GetMapping("/")
    public String root(Model model, HttpSession session) {
		model.addAttribute("userLogin", new UserLogin());
		model.addAttribute("newUser", new NewUser());
		session.invalidate();
		return "index";
    }
	
	
	@PostMapping("/login")
	public String saveUserLogin(@ModelAttribute("userLogin") UserLogin userLogin, HttpServletRequest request) {
		String userInput = userLogin.getUserName();
		String passInput = userLogin.getPassword();
		System.out.println("NAME: " + userInput);
		System.out.println("PASS: " + passInput);
		
		if (userLoginService.findByUserLoginName(userInput).isEmpty()) {
			return "redirect:/";
			
		} else if (userLoginService.findByUserLoginName(userInput).get(0).getPassword().equals(passInput)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userID", userLoginService.findByUserLoginName(userInput).get(0).getUserId());
			return "redirect:/profile";	
		} 
		
		return "redirect:/";
		
	}
	
	@PostMapping("/register")
	public String saveRegister(@ModelAttribute("newUser") NewUser newUser,
			@ModelAttribute("userLogin") UserLogin userLogin, HttpServletRequest request) {

		if (!userRepository.findByEmail(newUser.getEmail()).isEmpty() ||
				!userLoginService.findByUserLoginName(userLogin.getUserName()).isEmpty()) {

			return "redirect:/";
		}

		User user = new User();
		user.setFirstname(newUser.getFirstname());
		user.setLastname(newUser.getLastname());
		user.setEmail(newUser.getEmail());
		LocalDate dob = LocalDate.parse(newUser.getDateofbirth());
		user.setDateofbirth(dob);
		user.setPhonenumber(newUser.getPhonenumber());
		UserType userType = userTypeRepository.findByType(newUser.getUsertypeid()).get(0);
		user.setUsertype(userType);


		userRepository.save(user);
		Long userID = userRepository.findByEmail(newUser.getEmail()).get(0).getId();
		userLogin.setUserId(userID);
		userLoginService.registerUser(userLogin);

		HttpSession session = request.getSession(true);
		session.setAttribute("userID", userID);

		return "redirect:/profile";
	}

}
