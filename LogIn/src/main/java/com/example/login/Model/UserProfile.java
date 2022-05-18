package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class UserProfile{

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("kycActiveStatus")
	private String kycActiveStatus;

	@SerializedName("address")
	private String address;

	@SerializedName("panCard")
	private String panCard;

	@SerializedName("city")
	private String city;

	@SerializedName("mobileNumber")
	private String mobileNumber;

	@SerializedName("shopName")
	private String shopName;

	@SerializedName("userName")
	private String userName;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("parentBrand")
	private Object parentBrand;

	@SerializedName("kycActiveStatusDesc")
	private String kycActiveStatusDesc;

	@SerializedName("userType")
	private Object userType;

	@SerializedName("state")
	private String state;

	@SerializedName("email")
	private String email;

	@SerializedName("adharCard")
	private String adharCard;

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setKycActiveStatus(String kycActiveStatus){
		this.kycActiveStatus = kycActiveStatus;
	}

	public String getKycActiveStatus(){
		return kycActiveStatus;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setPanCard(String panCard){
		this.panCard = panCard;
	}

	public String getPanCard(){
		return panCard;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setMobileNumber(String mobileNumber){
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber(){
		return mobileNumber;
	}

	public void setShopName(String shopName){
		this.shopName = shopName;
	}

	public String getShopName(){
		return shopName;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setParentBrand(Object parentBrand){
		this.parentBrand = parentBrand;
	}

	public Object getParentBrand(){
		return parentBrand;
	}

	public void setKycActiveStatusDesc(String kycActiveStatusDesc){
		this.kycActiveStatusDesc = kycActiveStatusDesc;
	}

	public String getKycActiveStatusDesc(){
		return kycActiveStatusDesc;
	}

	public void setUserType(Object userType){
		this.userType = userType;
	}

	public Object getUserType(){
		return userType;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAdharCard(String adharCard){
		this.adharCard = adharCard;
	}

	public String getAdharCard(){
		return adharCard;
	}
}