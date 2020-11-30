package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RecordListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);

        Button btnAddRecord = findViewById(R.id.btnAddRecord);

        btnAddRecord.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Add Record selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), AddRecordActivity.class);
                startActivity(intent);
            }

        });


    }



}