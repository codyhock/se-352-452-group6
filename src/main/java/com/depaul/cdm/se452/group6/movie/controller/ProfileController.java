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
  public String showUser(Long id, Model model) {
      model.addAttribute("firstname", userService.findByUserId(1L).getFirstname());
      model.addAttribute("lastname", userService.findByUserId(1L).getLastname());
      model.addAttribute("email", userService.findByUserId(1L).getEmail());
      model.addAttribute("dateOfBirth", userService.findByUserId(1L).getDateOfBirth());
      model.addAttribute("phoneNumber", userService.findByUserId(1L).getPhoneNumber());
      model.addAttribute("type", userService.findByUserId(1L).getUsertype().getType());
      return "profile";
  }
  
}
  