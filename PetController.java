package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.casestudy.model.PetBean;
import com.casestudy.service.PetService;

@Controller
public class PetController {
	@Autowired
	private PetService petService;

	@RequestMapping(value = "/pet", method = RequestMethod.GET)
	public String getPets(Model model) {
		petService.getPets(model);
		return "home";
	}
	@RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
	public String getMyPets(Model model,@PathVariable Long id) {
		petService.getMyPets(model,id);
		return "home";
	}
	
	@RequestMapping(value = "/addPet", method = RequestMethod.GET)
	public String addPet(Model model) {
		model.addAttribute("msg", "Please Enter Your Pets Details");
		return "addPet";
	}

	@RequestMapping(value = "/addPet",method = RequestMethod.POST)
	public String savePet(Model model, @ModelAttribute("petBean") PetBean petBean) {
		return petService.addPet(model, petBean);
	}

}
