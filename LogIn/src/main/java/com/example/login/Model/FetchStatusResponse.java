package com.example.login.Model;

public class FetchStatusResponse{
	private String commonOnboardStatus;
	private String statusDesc;
	private Steps steps;
	private Remarks remarks;
	private int status;
	private boolean commonOnboarding;

	public void setCommonOnboardStatus(String commonOnboardStatus){
		this.commonOnboardStatus = commonOnboardStatus;
	}

	public String getCommonOnboardStatus(){
		return commonOnboardStatus;
	}

	public void setStatusDesc(String statusDesc){
		this.statusDesc = statusDesc;
	}

	public String getStatusDesc(){
		return statusDesc;
	}

	public void setSteps(Steps steps){
		this.steps = steps;
	}

	public Steps getSteps(){
		return steps;
	}

	public void setRemarks(Remarks remarks){
		this.remarks = remarks;
	}

	public Remarks getRemarks(){
		return remarks;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public void setCommonOnboarding(boolean commonOnboarding){
		this.commonOnboarding = commonOnboarding;
	}

	public boolean isCommonOnboarding(){
		return commonOnboarding;
	}
}
