package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.login.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        binding.adminNameText.setText(intent.getStringExtra("adminName"));
        binding.tokentext.setText(intent.getStringExtra("token"));
    }
}