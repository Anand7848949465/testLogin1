package com.example.login.Model;

public class RequestFetchUser{
	private String user_name;

	public RequestFetchUser(String user_name) {
		this.user_name = user_name;
	}

	public void setUserName(String userName){
		this.user_name = user_name;
	}

	public String getUserName(){
		return user_name;
	}
}
