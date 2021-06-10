package com.casestudy.dao;

import java.util.ArrayList;
import java.util.List;

import com.casestudy.model.RegistrationBean;

public class UserData {
	
	public static List<RegistrationBean> userDataList = new ArrayList<RegistrationBean>();

	public static List<RegistrationBean> getUserDataList() {
		return userDataList;
	}

	public static void setUserDataList(List<RegistrationBean> userDataList) {
		UserData.userDataList = userDataList;
	}
	
	
}
