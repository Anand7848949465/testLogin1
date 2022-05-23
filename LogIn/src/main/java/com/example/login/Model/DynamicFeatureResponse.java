package com.example.login.Model;

import java.util.List;

public class DynamicFeatureResponse{
	private String statusDesc;
	private int status;
	private List<UserFeatureItem> userFeature;

	public void setStatusDesc(String statusDesc){
		this.statusDesc = statusDesc;
	}

	public String getStatusDesc(){
		return statusDesc;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public void setUserFeature(List<UserFeatureItem> userFeature){
		this.userFeature = userFeature;
	}

	public List<UserFeatureItem> getUserFeature(){
		return userFeature;
	}
}