package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("Status")
	private String status;

	@SerializedName("MaximumBalance")
	private int maximumBalance;

	@SerializedName("Holdbalance")
	private int holdbalance;

	@SerializedName("Walletid")
	private String walletid;

	@SerializedName("MinimumBalance")
	private int minimumBalance;

	@SerializedName("Balance")
	private double balance;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setMaximumBalance(int maximumBalance){
		this.maximumBalance = maximumBalance;
	}

	public int getMaximumBalance(){
		return maximumBalance;
	}

	public void setHoldbalance(int holdbalance){
		this.holdbalance = holdbalance;
	}

	public int getHoldbalance(){
		return holdbalance;
	}

	public void setWalletid(String walletid){
		this.walletid = walletid;
	}

	public String getWalletid(){
		return walletid;
	}

	public void setMinimumBalance(int minimumBalance){
		this.minimumBalance = minimumBalance;
	}

	public int getMinimumBalance(){
		return minimumBalance;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}

	public double getBalance(){
		return balance;
	}
}