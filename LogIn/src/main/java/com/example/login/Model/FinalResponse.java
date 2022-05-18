package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class FinalResponse {
    @SerializedName("adminName")
    private String adminName;

    @SerializedName("token")
    private String token;

    public void setAdminName(String adminName){
        this.adminName = adminName;
    }

    public String getAdminName(){
        return adminName;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }
}
