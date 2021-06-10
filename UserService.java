package com.casestudy.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.casestudy.dao.PetsData;
import com.casestudy.dao.UserData;
import com.casestudy.model.LoginBean;
import com.casestudy.model.RegistrationBean;

@Service
public class UserService {
	
	public String saveUser(Model model, RegistrationBean registrationBean) {
		if (registrationBean != null && registrationBean.getUserName() != null && registrationBean.getPassword() != null
				&& registrationBean.getConfirmPassword() != null) {
			final String userName = registrationBean.getUserName(); 
			boolean isUserPresent = false;
			for(RegistrationBean r : UserData.getUserDataList()) {
				isUserPresent = userName.equals(r.getUserName());
			}
			
			if ( !isUserPresent && registrationBean.getPassword().equals(registrationBean.getConfirmPassword())) {
				registrationBean.setUserId((long) (UserData.getUserDataList().size()+1));
				UserData.getUserDataList().add(registrationBean);
				model.addAttribute("msg", registrationBean.getUserName()+" is register successfully ");
				model.addAttribute("successMsg", "User is register successfully ");
				return "success";
			} else {
				model.addAttribute("error", "User is already present");
				return "register";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "register";
		}
	}

	
	public String loginUser(Model model, LoginBean loginBean) {
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			
			final String userName = loginBean.getUserName(); 
			final String pass = loginBean.getPassword();
			boolean isUserPresent = false;
			for(RegistrationBean r : UserData.getUserDataList()) {
				isUserPresent = userName.equals(r.getUserName()) && pass.equals(r.getPassword());
			}
			if (isUserPresent) {
				model.addAttribute("msg", loginBean.getUserName());
				model.addAttribute("successMsg", "You have successfully logged in.");
				model.addAttribute("list", PetsData.getPets());
				return "home";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
}
