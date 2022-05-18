package com.example.login.Retrofit;

import com.example.login.Model.DashboardRespose;
import com.example.login.Model.FinalResponse;
import com.example.login.Model.RequestLoginDetails;
import com.example.login.Model.ResponseURL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("generate/v1")
    Call<ResponseURL> getUrl();
    @POST()
    Call<FinalResponse> getLogin(@Body RequestLoginDetails requestLoginDetails, @Url String url);

    @GET("generate/v2")
    Call<ResponseURL> getUrl2();
    @GET()
    Call<DashboardRespose> getData(@Header("Authorization") String token,@Url String url);
}
