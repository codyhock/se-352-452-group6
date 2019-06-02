package com.depaul.cdm.se452.group6.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class HistoryController {

    @GetMapping("/history")
    public String showUserHistory(Model model) {
        Date date2 = new Date();
        model.addAttribute("date2", date2.toString());

        //Forcing it to wait to demonstrate time passing
        try { Thread.sleep(1000);} catch(Exception e){}

        Date date = new Date();
        model.addAttribute("date", date.toString());

        return "history";
    }


    @RequestMapping(value="/history", method= RequestMethod.POST)
    public String saveHistory(Model model) {
        //TODO: Implement moving cart from Cart to PurchaseHistory
        Date date2 = new Date();
        model.addAttribute("date2", date2.toString());
        try { Thread.sleep(1000);} catch(Exception e){}
        Date date = new Date();
        model.addAttribute("date", date.toString());
        return "history";
    }
}
