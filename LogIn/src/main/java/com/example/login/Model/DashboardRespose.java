package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class DashboardRespose{

	@SerializedName("userInfo")
	private UserInfo userInfo;

	public void setUserInfo(UserInfo userInfo){
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo(){
		return userInfo;
	}
}