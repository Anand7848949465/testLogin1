package com.example.login.Model;

public class UserFeatureItem{
	private String featureName;
	private boolean active;
	private int id;

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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}
