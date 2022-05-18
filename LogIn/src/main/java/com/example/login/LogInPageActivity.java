package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;

import com.example.login.Model.FinalResponse;
import com.example.login.Model.RequestLoginDetails;
import com.example.login.Model.ResponseURL;
import com.example.login.Retrofit.ApiInterface;
import com.example.login.Retrofit.RetrofitInstance;
import com.example.login.databinding.ActivityLogInPageBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInPageActivity extends AppCompatActivity {
    ActivityLogInPageBinding binding;

    ApiInterface apiInterface;
    String url="";
    RequestLoginDetails requestLoginDetails;
    String userNameText="";
    String passwordText="";
    ProgressDialog progressDialog;
    String token="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLogInPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Wait....");



        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                apiInterface= RetrofitInstance.getRetrofit().create(ApiInterface.class);
                apiInterface.getUrl().enqueue(new Callback<ResponseURL>() {
                    @Override
                    public void onResponse(Call<ResponseURL> call, Response<ResponseURL> response) {
                        url=response.body().getHello();
                        userNameText=binding.userNameText.getText().toString();
                        passwordText=binding.passwordText.getText().toString();

                        requestLoginDetails=new RequestLoginDetails(userNameText,passwordText);
                        if(response!=null){
                            byte[] data = Base64.decode(url, Base64.DEFAULT);
                            String base64 = "";
                            try {
                                base64 = new String(data, "UTF-8");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Login(requestLoginDetails,base64);

                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseURL> call, Throwable t) {

                    }
                });

            }
        });




    }

    private void Login(RequestLoginDetails requestLoginDetails, String base64) {
        apiInterface.getLogin(requestLoginDetails,base64).enqueue(new Callback<FinalResponse>() {
            @Override
            public void onResponse(Call<FinalResponse> call, Response<FinalResponse> response) {

                if(response.body()!=null){
                    progressDialog.show();
                    progressDialog.setCanceledOnTouchOutside(false);
                    Intent intent=new Intent(LogInPageActivity.this,DashboardActivity.class);
                    intent.putExtra("token",response.body().getToken());
                    Constants.Token = response.body().getToken();
                    intent.putExtra("adminName",response.body().getAdminName());
                    startActivity(intent);
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<FinalResponse> call, Throwable t) {

            }
        });
    }
}