package com.casestudy.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.casestudy.dao.PetsData;
import com.casestudy.model.PetBean;

@Service
public class PetService {

	public void getMyPets(Model model, Long id) {
		getPets(model);
		
	}

	public String addPet(Model model, PetBean petBean) {
		petBean.setId((long)PetsData.getPets().size()+1);
		PetsData.getPets().add(petBean);
		getPets(model);
		return "home";
	}

	public void getPets(Model model) {
		model.addAttribute("list", PetsData.getPets());
	}

}
