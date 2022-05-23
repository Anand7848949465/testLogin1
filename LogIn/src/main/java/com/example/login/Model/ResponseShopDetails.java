package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseShopDetails{

	@SerializedName("date")
	private long date;

	@SerializedName("kyc_status")
	private String kycStatus;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("address")
	private String address;

	@SerializedName("role")
	private String role;

	@SerializedName("adminname")
	private String adminname;

	@SerializedName("mobileNumber")
	private String mobileNumber;

	@SerializedName("shopName")
	private String shopName;

	@SerializedName("statuscode")
	private String statuscode;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("id")
	private String id;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	@SerializedName("status")
	private String status;

	public void setDate(long date){
		this.date = date;
	}

	public long getDate(){
		return date;
	}

	public void setKycStatus(String kycStatus){
		this.kycStatus = kycStatus;
	}

	public String getKycStatus(){
		return kycStatus;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setAdminname(String adminname){
		this.adminname = adminname;
	}

	public String getAdminname(){
		return adminname;
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

	public void setStatuscode(String statuscode){
		this.statuscode = statuscode;
	}

	public String getStatuscode(){
		return statuscode;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}