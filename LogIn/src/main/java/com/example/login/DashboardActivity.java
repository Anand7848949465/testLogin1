package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.Model.DashboardRespose;
import com.example.login.Model.DynamicFeatureResponse;
import com.example.login.Model.FetchStatusResponse;
import com.example.login.Model.RequestFetchUser;
import com.example.login.Model.RequestLoginDetails;
import com.example.login.Model.ResponseAdminDetails;
import com.example.login.Model.ResponseShopDetails;
import com.example.login.Model.ResponseURL;
import com.example.login.Model.ResponseWallet2;
import com.example.login.Model.ResponseWalletCheckBalance;
import com.example.login.Retrofit.ApiInterface;
import com.example.login.Retrofit.RetrofitInstance;
import com.example.login.databinding.ActivityDashboardBinding;

import java.io.UnsupportedEncodingException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    private ApiInterface apiInterface;
    private String url="";
    private String token="";
    private String userName="";
    ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiInterface= RetrofitInstance.getRetrofit("https://itpl.iserveu.tech/").create(ApiInterface.class);
        Intent intent=getIntent();
        token=intent.getStringExtra("token");
        dashboardData();
        binding.userFeatureTextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(DashboardActivity.this,UserFeatureActivity.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                }
                });

        binding.fetchStatusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchStatus();
            }
        });
        binding.dynamicFeatureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFeatureDMT();
            }
        });
        binding.wallet1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWallet1Balance();
            }
        });
        binding.wallet2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWallet2Balance();
            }
        });
        binding.shopDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkShopDetails();
            }
        });
        binding.adminDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserRole();
            }
        });
    }

    private void checkUserRole() {
        apiInterface=RetrofitInstance.getRetrofit("https://itpl.iserveu.tech/").create(ApiInterface.class);
        apiInterface.getDecodeAdminDetailsUrl().enqueue(new Callback<ResponseURL>() {
            @Override
            public void onResponse(Call<ResponseURL> call, Response<ResponseURL> response) {
                if(response.isSuccessful()){
                    url=response.body().getHello();
                    byte[] data=Base64.decode(url,Base64.DEFAULT);
                    String encodedUrl="";
                    try {
                        encodedUrl=new String(data,"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    getAdminDetails(encodedUrl);
                }
                else {
                    Toast.makeText(DashboardActivity.this, "Url not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseURL> call, Throwable t) {

            }
        });
    }

    private void getAdminDetails(String encodedUrl) {
        RequestLoginDetails requestLoginDetails=new RequestLoginDetails(userName);
        apiInterface.getAdminDetails(encodedUrl,token,requestLoginDetails).enqueue(new Callback<ResponseAdminDetails>() {
            @Override
            public void onResponse(Call<ResponseAdminDetails> call, Response<ResponseAdminDetails> response) {
                if(response.isSuccessful()){
                    Toast.makeText(DashboardActivity.this,"masterDistributor : " + response.body().getMasterDistributor(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DashboardActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAdminDetails> call, Throwable t) {

            }
        });
    }

    private void checkShopDetails() {
        apiInterface =RetrofitInstance.getRetrofit("https://itpl.iserveu.tech/").create(ApiInterface.class);
        apiInterface.getDecodeShopDetailsUrl().enqueue(new Callback<ResponseURL>() {
            @Override
            public void onResponse(Call<ResponseURL> call, Response<ResponseURL> response) {
                if(response.isSuccessful()){
                    url=response.body().getHello();
                    byte[] data=Base64.decode(url,Base64.DEFAULT);
                    String encodedShopUrl="";
                    try {
                        encodedShopUrl=new String(data,"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    getShopDetails(encodedShopUrl);
                }
            }

            @Override
            public void onFailure(Call<ResponseURL> call, Throwable t) {

            }
        });
    }

    private void getShopDetails(String encodedShopUrl) {
        apiInterface.getShopDetails(encodedShopUrl,token).enqueue(new Callback<ResponseShopDetails>() {
            @Override
            public void onResponse(Call<ResponseShopDetails> call, Response<ResponseShopDetails> response) {
                if(response.isSuccessful()){
                    Toast.makeText(DashboardActivity.this, "Shop Name: "+response.body().getShopName() +
                            "\nAddress : "+response.body().getAddress(), Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(DashboardActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseShopDetails> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getWallet2Balance() {
        RequestFetchUser requestFetchUser=new RequestFetchUser(userName);
        apiInterface=RetrofitInstance.getRetrofit("https://itpl.iserveu.tech/").create(ApiInterface.class);
        apiInterface.getDecodeUrl3().enqueue(new Callback<ResponseURL>() {
            @Override
            public void onResponse(Call<ResponseURL> call, Response<ResponseURL> response) {
                if(response.isSuccessful()){
                    url=response.body().getHello();
                    byte[] data=Base64.decode(url,Base64.DEFAULT);
                    String encodedUrl="";
                    try {
                        encodedUrl=new String(data,"UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(DashboardActivity.this, encodedUrl, Toast.LENGTH_SHORT).show();
                    getWallet2BalanceEncripted(encodedUrl);
                }
            }

            @Override
            public void onFailure(Call<ResponseURL> call, Throwable t) {

            }
        });
    }

    private void getWallet2BalanceEncripted(String encodedUrl) {
        Log.d("Token id",token);
        apiInterface.getWallet2Balance(token,encodedUrl).enqueue(new Callback<ResponseWallet2>() {
            @Override
            public void onResponse(Call<ResponseWallet2> call, Response<ResponseWallet2> response) {
                if(response.isSuccessful()){
                    Toast.makeText(DashboardActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DashboardActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseWallet2> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getWallet1Balance() {
        RequestFetchUser requestFetchUser =new RequestFetchUser(userName);
        apiInterface=RetrofitInstance.getRetrofit("https://grpcwalletprod.iserveu.tech/").create(ApiInterface.class);
        apiInterface.getWallet1Balance(requestFetchUser).enqueue(new Callback<ResponseWalletCheckBalance>() {
            @Override
            public void onResponse(Call<ResponseWalletCheckBalance> call, Response<ResponseWalletCheckBalance> response) {
                if(response.isSuccessful()){
                    String balance= String.format("%.2f",response.body().getResponse().getBalance());
                    Toast.makeText(DashboardActivity.this,balance, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DashboardActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseWalletCheckBalance> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getFeatureDMT() {
        RequestFetchUser requestFetchUser =new RequestFetchUser(userName);
        apiInterface=RetrofitInstance.getRetrofit("https://dynamicfeatureprod.iserveu.online/").create(ApiInterface.class);
        apiInterface.getFetchUserFeature(requestFetchUser,token).enqueue(new Callback<DynamicFeatureResponse>() {
            @Override
            public void onResponse(Call<DynamicFeatureResponse> call, Response<DynamicFeatureResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(DashboardActivity.this, response.body().getStatusDesc(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DashboardActivity.this, "Data Not Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DynamicFeatureResponse> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dashboardData() {
        apiInterface.getDecodedDashboardUrl().enqueue(new Callback<ResponseURL>() {
            @Override
            public void onResponse(Call<ResponseURL> call, Response<ResponseURL> response) {
                url=response.body().getHello();
                byte[] data= Base64.decode(url,Base64.DEFAULT);
                String base64="";
                try {
                    base64=new String(data,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                getDashboard(base64);
            }
            @Override
            public void onFailure(Call<ResponseURL> call, Throwable t) {
            }
        });
    }

    private void fetchStatus() {
        apiInterface=RetrofitInstance.getRetrofit("https://common-onboarding.iserveu.tech/").create(ApiInterface.class);
        RequestLoginDetails requestLoginDetails=new RequestLoginDetails(userName);
        apiInterface.getFetchData(requestLoginDetails).enqueue(new Callback<FetchStatusResponse>() {
            @Override
            public void onResponse(Call<FetchStatusResponse> call, Response<FetchStatusResponse> response) {
                if(response.body()!=null){
                    Intent intent=new Intent(DashboardActivity.this,FetchStatusActivity.class);
                    intent.putExtra("common_onboard_status",response.body().getStatusDesc());
//                            Toast.makeText(DashboardActivity.this,response.body().getStatusDesc() , Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else {
                    Toast.makeText(DashboardActivity.this, "Data not found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<FetchStatusResponse> call, Throwable t) {
                Toast.makeText(DashboardActivity.this, "Api Call Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDashboard(String base64) {
        apiInterface.getDashboardData(token,base64).enqueue(new Callback<DashboardRespose>() {
            @Override
            public void onResponse(Call<DashboardRespose> call, Response<DashboardRespose> response) {
                if(response.body()!=null){
                    binding.userNameEditText.setText(response.body().getUserInfo().getUserName());
                    binding.userTypeEditText.setText(response.body().getUserInfo().getUserType());
                    binding.userBalanceEditText.setText(response.body().getUserInfo().getUserBalance());
                    binding.adminNameEditText.setText(response.body().getUserInfo().getAdminName());
                    binding.mPosNoEditText.setText(response.body().getUserInfo().getMposNumber());
                    userName=response.body().getUserInfo().getUserName();
                }
            }

            @Override
            public void onFailure(Call<DashboardRespose> call, Throwable t) {

            }
        });
    }
}