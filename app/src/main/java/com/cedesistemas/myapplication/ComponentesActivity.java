package com.cedesistemas.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import static com.cedesistemas.myapplication.Constants.ORDER;

public class ComponentesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String TAG = "ComponentesActivity";
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compontentes);

        order = new Order();

        loadDataFoodList();
    }

    private void loadDataFoodList() {
        Spinner foodSpinner = findViewById(R.id.food_spinner);
        foodSpinner.setOnItemSelectedListener(this); //set listener to spinner
        ArrayAdapter<CharSequence> foodAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.food_list, android.R.layout.simple_spinner_item);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodSpinner.setAdapter(foodAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String foodSelected = (String) adapterView.getItemAtPosition(position);
        Log.i(TAG, foodSelected);
        order.setFood(foodSelected);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //TODO
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String added = checked ? "Con" : "Sin";

        switch (view.getId()){
            case R.id.soda_checkbox:
                Log.i(TAG, added + " Soda");
                order.setHasSoda(checked);
                break;
            case R.id.snack_checkbox:
                Log.i(TAG, added + " Snack");
                order.setHasSoda(checked);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "On start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "On resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "On restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "On pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "On destroy");
    }

    public void onOrderButtonClicked(View view) {
        Intent intent = new Intent(ComponentesActivity.this, OrderActivity.class);
        intent.putExtra(ORDER, order);
        startActivityForResult(intent, RESULT_OK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            Toast.makeText(this, "Recibiendo...", Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
