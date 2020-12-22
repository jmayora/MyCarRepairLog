package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddRecordActivity extends AppCompatActivity {

    EditText edtTextDetail, edtTextDate, edtTextKilometers;
    TextView textAuto;

    int ID = 0, kilometers1= 0, kilometer2 = 0;
    String detail = "";
    String date1 = "";
    String auto = "";
    String date2 = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        textAuto = findViewById(R.id.textAuto);
        edtTextDate = findViewById(R.id.editTextDate);
        edtTextDetail = findViewById(R.id.editTextDetail);
        edtTextKilometers = findViewById(R.id.editTextKilometers);

        Intent intent = getIntent();
        ID = intent.getIntExtra("ID", 0);
        auto = intent.getStringExtra("autoBrand") + " " +intent.getStringExtra("autoModel");

        textAuto.setText(auto + " " + ID);

    }

    public void insertLogRecord(View view){
        detail = edtTextDetail.getText().toString();
        date1 = edtTextDate.getText().toString();

        kilometers1 = Integer.parseInt(edtTextKilometers.getText().toString());

        Toast.makeText(getApplicationContext(), "Date: " + date1 + " , Kilometers: " + kilometers1 + " , Details: " + detail, Toast.LENGTH_SHORT).show();

        //LogRecordModel logRecordModel = new LogRecordModel(ID, kilometers1, kilometer2, detail, date1, date2);

    }
}