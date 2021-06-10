package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.casestudy.dao.PetsData;
import com.casestudy.model.LoginBean;
import com.casestudy.model.RegistrationBean;
import com.casestudy.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userSevice;
	
	@RequestMapping( method = RequestMethod.GET)
	public String main(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "main";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("msg", "Pets Details");
		model.addAttribute("list", PetsData.getPets());
		return "home";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		return userSevice.loginUser(model, loginBean);
	}

	@RequestMapping( value = "/logout", method = RequestMethod.GET)
	public String Logout(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "main";
	}
}
