package com.example.login.Retrofit;

import com.example.login.Model.FinalResponse;
import com.example.login.Model.RequestLoginDetails;
import com.example.login.Model.ResponseURL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("generate/v1")
    Call<ResponseURL> getUrl();
    @POST()
    Call<FinalResponse> getLogin(@Body RequestLoginDetails requestLoginDetails, @Url String url);
}
