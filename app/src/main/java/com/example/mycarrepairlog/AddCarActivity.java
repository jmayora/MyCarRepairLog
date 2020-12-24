package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddCarActivity extends AppCompatActivity {

    TextView editTxtCarBrand, editTxtCarModel, editTxtCarYear, editTxtCarKilometers;
    TextView editTxtChassis, editTxtLicense, editTxtInsurance;
    Button btnInsertCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        editTxtCarBrand = findViewById(R.id.editTxtCarBrandu);
        editTxtCarModel = findViewById(R.id.editTxtCarModelu);
        editTxtCarYear = findViewById(R.id.editTxtCarYearu);
        editTxtCarKilometers = findViewById(R.id.editTxtChassis);
        btnInsertCar = findViewById(R.id.btnInsertCar);

    }


    public void insertCar(View view){

        String carBrand = editTxtCarBrand.getText().toString();
        String carModel = editTxtCarModel.getText().toString();
        int carYear = Integer.parseInt(editTxtCarYear.getText().toString());
        String chassis = editTxtChassis.getText().toString();
        String license = editTxtLicense.getText().toString();
        String insurance = editTxtInsurance.getText().toString();

        AutoModel auto = new AutoModel(carBrand, carModel, carYear, chassis, license, insurance);

        Log.d("Auto Info: ", auto.toString());

        MyDBHelper myDBHelper = new MyDBHelper(this);
        boolean success = myDBHelper.addOne(auto);
        if (success) {
            Toast.makeText(getApplicationContext(), "Inserted " + carBrand, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Insert failed", Toast.LENGTH_LONG).show();
        }

    }
}