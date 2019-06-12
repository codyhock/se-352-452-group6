package com.depaul.cdm.se452.group6.movie.controller;
import com.depaul.cdm.se452.group6.movie.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.depaul.cdm.se452.group6.movie.service.UserService;

@Controller
public class ProfileController {
	
  public UserService userService;
  
  public ProfileController (UserService userService) {
	  this.userService = userService;
  }
  

  @GetMapping("/profile")
  public String showUser(Long id, Model model, @SessionAttribute(name="userID") Long userID) {
      User user = userService.findByUserId(userID, userID);
      model.addAttribute("firstname", user.getFirstname());
      model.addAttribute("lastname", user.getLastname());
      model.addAttribute("email", user.getEmail());
      model.addAttribute("dateOfBirth", user.getDateofbirth());
      model.addAttribute("phoneNumber", user.getPhonenumber());
      model.addAttribute("type", user.getUsertype().getType());
      return "profile";
  }
  
}
  