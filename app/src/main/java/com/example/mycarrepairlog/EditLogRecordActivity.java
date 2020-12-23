package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EditLogRecordActivity extends AppCompatActivity {
    private String date, kilometers, detail;
    TextView edtTextDate, edtTextKilometers, edtTextDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_log_record);

        edtTextDate = findViewById(R.id.edtTextDate);
        edtTextKilometers = findViewById(R.id.edtTextKilometers);
        edtTextDetail = findViewById(R.id.edtTextDetail);

        Intent intent = getIntent();
        date = intent.getStringExtra("date");
        kilometers = intent.getStringExtra("kilometers");
        detail = intent.getStringExtra("detail");
        edtTextDate.setText(date);
        edtTextKilometers.setText(kilometers);
        edtTextDetail.setText(detail);

    }
}