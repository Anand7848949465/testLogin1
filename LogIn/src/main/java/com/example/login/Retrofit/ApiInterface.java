package com.example.login.Retrofit;

import com.example.login.Model.DashboardRespose;
import com.example.login.Model.DynamicFeatureResponse;
import com.example.login.Model.FetchStatusResponse;
import com.example.login.Model.FinalResponse;
import com.example.login.Model.RequestFetchUser;
import com.example.login.Model.RequestLoginDetails;
import com.example.login.Model.ResponseAdminDetails;
import com.example.login.Model.ResponseShopDetails;
import com.example.login.Model.ResponseURL;
import com.example.login.Model.ResponseWallet2;
import com.example.login.Model.ResponseWalletCheckBalance;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("generate/v1")
    Call<ResponseURL> getDecodedLoginUrl();

    @POST()
    Call<FinalResponse> getLogin(@Body RequestLoginDetails requestLoginDetails, @Url String url);

    @GET("generate/v2")
    Call<ResponseURL> getDecodedDashboardUrl();

    @GET()
    Call<DashboardRespose> getDashboardData(@Header("Authorization") String token,@Url String url);


    @POST("api/v1/fetchStatus")
    Call<FetchStatusResponse> getFetchData(@Body RequestLoginDetails requestLoginDetails );

    @POST("fetch_user_feature")
    Call<DynamicFeatureResponse> getFetchUserFeature(@Body RequestFetchUser requestFetchUser, @Header("Authorization") String token);

    @POST("wallet/checkbalance")
    Call<ResponseWalletCheckBalance> getWallet1Balance(@Body RequestFetchUser requestFetchUser);

    @GET("generate/v72")
    Call<ResponseURL>getDecodeUrl3();

    @GET()
    Call<ResponseWallet2> getWallet2Balance(@Header("Authorization") String token, @Url String url);

    @GET("generate/v56")
    Call<ResponseURL>getDecodeShopDetailsUrl();

    @GET()
    Call<ResponseShopDetails> getShopDetails(@Url String url,@Header("Authorization") String token);

    @GET("generate/v51")
    Call<ResponseURL> getDecodeAdminDetailsUrl();

    @POST()
    Call<ResponseAdminDetails> getAdminDetails(@Url String url,@Header("Authorization") String token,@Body RequestLoginDetails requestLoginDetails);


}
