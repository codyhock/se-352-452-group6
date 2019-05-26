package com.depaul.cdm.se452.group6.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

  @GetMapping("/profile")
  public String showUser(Model model) {
      model.addAttribute("firstname", "Admin");
      model.addAttribute("lastname", "Adminadmin");
      return "profile";
  }
}
  