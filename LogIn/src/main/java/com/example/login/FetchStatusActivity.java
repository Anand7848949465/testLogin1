package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FetchStatusActivity extends AppCompatActivity {
    TextView common_onboard_statusText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_status);
        common_onboard_statusText=findViewById(R.id.common_onboard_statusText);
        Intent intent=getIntent();
        String common_onboard_status=intent.getStringExtra("common_onboard_status");
        common_onboard_statusText.setText(common_onboard_status);
    }
}