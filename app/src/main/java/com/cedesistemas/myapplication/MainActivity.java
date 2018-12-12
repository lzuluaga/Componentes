package com.cedesistemas.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.cedesistemas.myapplication.Constants.*;


public class MainActivity extends AppCompatActivity implements TextWatcher {

    private EditText etUser;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        etUser.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);
        //opción 1
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (etUser.getText().toString().trim().isEmpty() ||
                etPassword.getText().toString().trim().isEmpty()) {
            btnLogin.setEnabled(false);
        }else{
            btnLogin.setEnabled(true);
        }
    }

    public void login(View view) {
        User user = new User();

        Intent intent = new Intent(MainActivity.this, ComponentesActivity.class);
        intent.putExtra(USER_NAME, etUser.getText().toString());
        intent.putExtra(USER_OBJECT, user);
        startActivity(intent);
    }
}
