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
import com.example.login.Model.ResponseURL;
import com.example.login.Retrofit.ApiInterface;
import com.example.login.Retrofit.RetrofitInstance;
import com.example.login.databinding.ActivityDashboardBinding;

import java.io.UnsupportedEncodingException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    String url="";
    String token="";


    ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiInterface= RetrofitInstance.getRetrofit().create(ApiInterface.class);
        Intent intent=getIntent();
        token=intent.getStringExtra("token");

        Log.e("TAG", "token: "+token );
binding.userFeatureTextBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(DashboardActivity.this,UserFeatureActivity.class);
        startActivity(intent);
    }
});


        apiInterface.getUrl2().enqueue(new Callback<ResponseURL>() {
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
                getDashboard(token,base64);

            }

            @Override
            public void onFailure(Call<ResponseURL> call, Throwable t) {

            }
        });
    }

    private void getDashboard(String token, String base64) {
        apiInterface.getData(token,base64).enqueue(new Callback<DashboardRespose>() {
            @Override
            public void onResponse(Call<DashboardRespose> call, Response<DashboardRespose> response) {
                if(response.body()!=null){
                    binding.userNameEditText.setText(response.body().getUserInfo().getUserName());
                    binding.userTypeEditText.setText(response.body().getUserInfo().getUserType());
                    binding.userBalanceEditText.setText(response.body().getUserInfo().getUserBalance());
                    binding.adminNameEditText.setText(response.body().getUserInfo().getAdminName());
                    binding.mPosNoEditText.setText(response.body().getUserInfo().getMposNumber());
                }
            }

            @Override
            public void onFailure(Call<DashboardRespose> call, Throwable t) {

            }
        });
    }
}