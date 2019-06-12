package com.depaul.cdm.se452.group6.movie.controller;
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
      model.addAttribute("firstname", userService.findByUserId(userID).getFirstname());
      model.addAttribute("lastname", userService.findByUserId(userID).getLastname());
      model.addAttribute("email", userService.findByUserId(userID).getEmail());
      model.addAttribute("dateOfBirth", userService.findByUserId(userID).getDateofbirth());
      model.addAttribute("phoneNumber", userService.findByUserId(userID).getPhonenumber());
      model.addAttribute("type", userService.findByUserId(userID).getUsertype().getType());
      return "profile";
  }
  
}
  