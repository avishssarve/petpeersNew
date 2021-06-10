package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.casestudy.model.RegistrationBean;
import com.casestudy.service.UserService;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {
	
	@Autowired
	private UserService userSevice;
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Registration Details");
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("registrationBean") RegistrationBean registrationBean) {
		return userSevice.saveUser(model, registrationBean);
	}

	
}
