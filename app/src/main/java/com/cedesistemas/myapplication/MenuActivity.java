package com.cedesistemas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView tvUser;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tvUser = findViewById(R.id.tvUser);
        tvUser.setText(getIntent().getStringExtra("nombre"));
        user = (User) getIntent().getSerializableExtra("objeto");


    }
}
