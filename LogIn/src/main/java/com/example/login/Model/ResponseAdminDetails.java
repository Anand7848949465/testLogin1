package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseAdminDetails{

	@SerializedName("masterDistributor")
	private String masterDistributor;

	public void setMasterDistributor(String masterDistributor){
		this.masterDistributor = masterDistributor;
	}

	public String getMasterDistributor(){
		return masterDistributor;
	}
}