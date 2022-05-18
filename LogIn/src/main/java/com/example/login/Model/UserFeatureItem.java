package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class UserFeatureItem{

	@SerializedName("featureName")
	private String featureName;

	@SerializedName("active")
	private boolean active;

	@SerializedName("id")
	private String id;

	public void setFeatureName(String featureName){
		this.featureName = featureName;
	}

	public String getFeatureName(){
		return featureName;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}
}