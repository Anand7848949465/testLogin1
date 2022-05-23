package com.example.login.Model;

import com.google.gson.annotations.SerializedName;

public class RequestLoginDetails {

    @SerializedName("password")
    private String password;

    @SerializedName("username")
    private String username;
    private String user_name;

    public RequestLoginDetails(String username, String password) {
        this.password = password;
        this.username = username;
    }
    public RequestLoginDetails(String username){
        this.username=username;
    }


    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }
}
