package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddRecordActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText edtTextDetail, edtTextDate, edtTextKilometers;
    TextView textAuto;

    int ID = 1, kilometers= 0;
    String detail = "";
    String date = "";
    String auto = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        textAuto = findViewById(R.id.textAuto);
        edtTextDate = findViewById(R.id.editTextDate);
        edtTextDetail = findViewById(R.id.editTextDetail);
        edtTextKilometers = findViewById(R.id.editTextKilometers);

        Intent intent = getIntent();
        ID = intent.getIntExtra("auto_ID", 1);
        auto = intent.getStringExtra("autoBrand") + " " +intent.getStringExtra("autoModel");
        String text = auto + " " + ID;
        textAuto.setText(text);

        edtTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }


    public void insertLogRecord(View view){
        detail = edtTextDetail.getText().toString();
        date = edtTextDate.getText().toString();
        kilometers = Integer.parseInt(edtTextKilometers.getText().toString());

        Toast.makeText(getApplicationContext(), "Date: " + date + " , Kilometers: " + kilometers + " , Details: " + detail, Toast.LENGTH_SHORT).show();

        MyDBHelper myDBHelper = new MyDBHelper(this);
        LogRecordModel logRecordModel = new LogRecordModel(ID, date, kilometers, detail);
        boolean success = myDBHelper.addLogRecord(logRecordModel);
        if (success) {
            Toast.makeText(getApplicationContext(), "Inserted log record", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Insert failed", Toast.LENGTH_LONG).show();
        }
        success = myDBHelper.updateAutoMaintenanceData(logRecordModel);
        if (success) {
            Toast.makeText(getApplicationContext(), "Updated car data", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Update failed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year , int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + (month+1) + "/" + year;
        edtTextDate.setText(date);
    }
}