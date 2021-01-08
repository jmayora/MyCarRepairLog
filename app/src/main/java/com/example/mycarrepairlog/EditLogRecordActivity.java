package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class EditLogRecordActivity extends AppCompatActivity {
    private String date, kilometers, detail;
    TextView edtTextDate, edtTextKilometers, edtTextDetail;
    ImageButton ibtnSaveRecord;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_log_record);

        edtTextDate = findViewById(R.id.edtTextDate);
        edtTextKilometers = findViewById(R.id.edtTextKilometers);
        edtTextDetail = findViewById(R.id.edtTextDetail);
        ibtnSaveRecord = findViewById(R.id.ibtnSaveRecord);

        Intent intent = getIntent();
        ID = intent.getIntExtra("ID", 0);
        date = intent.getStringExtra("date");
        kilometers = intent.getStringExtra("kilometers");
        detail = intent.getStringExtra("detail");
        edtTextDate.setText(date);
        edtTextKilometers.setText(kilometers);
        edtTextDetail.setText(detail);

        ibtnSaveRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = edtTextDate.getText().toString();
                kilometers = edtTextKilometers.getText().toString();
                detail = edtTextDetail.getText().toString();

                LogRecordModel logRecordModel = new LogRecordModel(ID,date, Integer.parseInt(kilometers),detail);
                MyDBHelper myDBHelper = new MyDBHelper(getApplicationContext());
                boolean success = myDBHelper.updateLogRecord(logRecordModel);

                if (success) {
                    Toast.makeText(getApplicationContext(), "Log Record Updated " , Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Log Record Update failed", Toast.LENGTH_LONG).show();
                }

                success = myDBHelper.updateAutoMaintenanceData(logRecordModel);
                if (success) {
                    Toast.makeText(getApplicationContext(), "Auto Updated " , Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Auto Update failed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}