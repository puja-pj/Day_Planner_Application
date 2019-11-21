package com.puja.DayPlanner.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.puja.DayPlanner.model.User;



@Controller
public class HomeController {

	@Autowired
	private com.puja.DayPlanner.service.UserService userservice;

	@RequestMapping("/")
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		com.puja.DayPlanner.model.User user=new com.puja.DayPlanner.model.User();
		model.addAttribute("user",user);
		return "register";
	}
	
			
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User userModel,BindingResult bindingResult) {
		//System.out.println("username is :"+userModel.getUsername());
		if(bindingResult.hasErrors()) {
			System.out.println("Register username is :"+userModel.getUsername());
			return "register";
		}
		else {
			this.userservice.create(userModel);
			
			
			return "redirect:/login";
	}
	}
		
		

}

