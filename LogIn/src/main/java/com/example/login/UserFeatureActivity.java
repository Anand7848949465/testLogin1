package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Toast;

import com.example.login.Adapter.FeatureAdapter;
import com.example.login.Model.DashboardRespose;
import com.example.login.Model.ResponseURL;
import com.example.login.Model.UserFeatureItem;
import com.example.login.Retrofit.ApiInterface;
import com.example.login.Retrofit.RetrofitInstance;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFeatureActivity extends AppCompatActivity {
//    List<UserFeatureItem> list=new Lis
    RecyclerView recyclerView;
    ArrayList<UserFeatureItem> list=new ArrayList<>();
    ApiInterface apiInterface;
    String url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_feature);
        recyclerView=findViewById(R.id.featureRecyclerView);
//        FeatureAdapter adapter=new FeatureAdapter(list,this);
//        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        apiInterface= RetrofitInstance.getRetrofit().create(ApiInterface.class);



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
                getDashboard(base64);

            }

            @Override
            public void onFailure(Call<ResponseURL> call, Throwable t) {
        t.printStackTrace();
            }
        });
    }

    private void getDashboard(String base64) {
        apiInterface.getData(Constants.Token,base64).enqueue(new Callback<DashboardRespose>() {
            @Override
            public void onResponse(Call<DashboardRespose> call, Response<DashboardRespose> response) {
                if(response.body()!=null){
                    list = (ArrayList<UserFeatureItem>) response.body().getUserInfo().getUserFeature();
                    FeatureAdapter featureAdapter = new FeatureAdapter(list,UserFeatureActivity.this);
                    recyclerView.setAdapter(featureAdapter);
                }
            }

            @Override
            public void onFailure(Call<DashboardRespose> call, Throwable t) {

            }
        });


    }
}