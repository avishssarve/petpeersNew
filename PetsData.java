package com.casestudy.dao;

import java.util.ArrayList;
import java.util.List;

import com.casestudy.model.PetBean;

public class PetsData {
	public static List<PetBean> petsDataList = new ArrayList<PetBean>();

	public static List<PetBean> getPets() {
		System.out.println(petsDataList.toString());
		return petsDataList;	
	}

}
