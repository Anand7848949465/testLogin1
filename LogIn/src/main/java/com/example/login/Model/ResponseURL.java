package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseURL{

	@SerializedName("hello")
	private String hello;
	public void setHello(String hello){
		this.hello = hello;
	}

	public String getHello(){
		return hello;
	}
}