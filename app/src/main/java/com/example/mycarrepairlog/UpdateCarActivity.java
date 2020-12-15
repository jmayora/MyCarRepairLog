package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UpdateCarActivity extends AppCompatActivity {

    TextView edtTxtViewCarBrand;
    TextView edtTxtViewCarModel;
    TextView edtTxtViewCarYear;
    TextView txtViewID2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_car);

        edtTxtViewCarBrand = findViewById(R.id.editTxtCarBrandu);
        edtTxtViewCarModel = findViewById(R.id.editTxtCarModelu);
        edtTxtViewCarYear = findViewById(R.id.editTxtCarYearu);
        txtViewID2 = findViewById(R.id.txtViewID2);

        Intent intent = getIntent();

        edtTxtViewCarBrand.setText(intent.getStringExtra("autoBrand"));
        edtTxtViewCarModel.setText(intent.getStringExtra("autoModel"));
        edtTxtViewCarYear.setText(String.valueOf(intent.getIntExtra("autoYear", 2000)));
        txtViewID2.setText(String.valueOf(intent.getIntExtra("ID", 0)));
    }
}