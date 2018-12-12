package com.cedesistemas.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.cedesistemas.myapplication.Constants.CONFIRMATION;
import static com.cedesistemas.myapplication.Constants.ORDER;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Order order = (Order) getIntent().getSerializableExtra(ORDER);
        showToastMessage(order);
    }

    private void showToastMessage(Order order) {
        Toast.makeText(this, "La orden es de " + order.getFood().toString(),
                Toast.LENGTH_LONG).show();
    }


    public void onBack(View view) {
        //1 Option (Using finish method)
        //finish();
        Intent intent = new Intent();
        intent.putExtra(CONFIRMATION, true);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(CONFIRMATION, true);
        setResult(RESULT_OK);
        super.onBackPressed();
    }
}
