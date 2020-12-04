package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddCarActivity extends AppCompatActivity {

    TextView editTxtCarBrand, editTxtCarModel, editTxtCarYear, editTxtCarKilometers;
    Button btnInsertCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        editTxtCarBrand = findViewById(R.id.editTxtCarBrand);
        editTxtCarModel = findViewById(R.id.editTxtCarModel);
        editTxtCarYear = findViewById(R.id.editTxtCarYear);
        editTxtCarKilometers = findViewById(R.id.editTxtCarKilometers);
        btnInsertCar = findViewById(R.id.btnInsertCar);

    }


    public void insertCar(View view){

        String carBrand = editTxtCarBrand.getText().toString();
        String carModel = editTxtCarModel.getText().toString();
        int carYear = Integer.parseInt(editTxtCarYear.getText().toString());
        int carKilometers = Integer.parseInt(editTxtCarKilometers.getText().toString());

        Auto auto = new Auto(carBrand, carModel, carYear, carKilometers);

        Log.d("Auto Info: ", auto.toString());

        MyDBHelper myDBHelper = new MyDBHelper(this);
    }
}