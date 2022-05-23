package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseWalletCheckBalance{

	@SerializedName("response")
	private Response response;

	@SerializedName("errorMessage")
	private String errorMessage;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
}