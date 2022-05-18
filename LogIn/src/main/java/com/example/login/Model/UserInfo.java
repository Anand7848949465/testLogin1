package com.example.login.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserInfo{

	@SerializedName("adminName")
	private String adminName;

	@SerializedName("mposNumber")
	private String mposNumber;

	@SerializedName("userType")
	private String userType;

	@SerializedName("userBalance")
	private String userBalance;

	@SerializedName("promotionalMessage")
	private String promotionalMessage;

	@SerializedName("userName")
	private String userName;

	@SerializedName("userProfile")
	private UserProfile userProfile;

	@SerializedName("userBrand")
	private String userBrand;

	@SerializedName("userFeature")
	private List<UserFeatureItem> userFeature;

	public void setAdminName(String adminName){
		this.adminName = adminName;
	}

	public String getAdminName(){
		return adminName;
	}

	public void setMposNumber(String mposNumber){
		this.mposNumber = mposNumber;
	}

	public String getMposNumber(){
		return mposNumber;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getUserType(){
		return userType;
	}

	public void setUserBalance(String userBalance){
		this.userBalance = userBalance;
	}

	public String getUserBalance(){
		return userBalance;
	}

	public void setPromotionalMessage(String promotionalMessage){
		this.promotionalMessage = promotionalMessage;
	}

	public String getPromotionalMessage(){
		return promotionalMessage;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	public void setUserProfile(UserProfile userProfile){
		this.userProfile = userProfile;
	}

	public UserProfile getUserProfile(){
		return userProfile;
	}

	public void setUserBrand(String userBrand){
		this.userBrand = userBrand;
	}

	public String getUserBrand(){
		return userBrand;
	}

	public void setUserFeature(List<UserFeatureItem> userFeature){
		this.userFeature = userFeature;
	}

	public List<UserFeatureItem> getUserFeature(){
		return userFeature;
	}
}