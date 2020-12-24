package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateCarActivity extends AppCompatActivity {

    TextView edtTxtViewCarBrand;
    TextView edtTxtViewCarModel;
    TextView edtTxtViewCarYear;
    TextView txtViewID2;
    ImageButton ibtnUpdateCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_car);

        edtTxtViewCarBrand = findViewById(R.id.editTxtCarBrandu);
        edtTxtViewCarModel = findViewById(R.id.editTxtCarModelu);
        edtTxtViewCarYear = findViewById(R.id.editTxtCarYearu);
        txtViewID2 = findViewById(R.id.txtViewID2);
        ibtnUpdateCar = findViewById(R.id.ibtnUpdateCar);

        Intent intent = getIntent();

        edtTxtViewCarBrand.setText(intent.getStringExtra("autoBrand"));
        edtTxtViewCarModel.setText(intent.getStringExtra("autoModel"));
        edtTxtViewCarYear.setText(String.valueOf(intent.getIntExtra("autoYear", 2000)));
        txtViewID2.setText(String.valueOf(intent.getIntExtra("ID", 0)));

        ibtnUpdateCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ID = intent.getIntExtra("ID", 1);
                String carBrand = edtTxtViewCarBrand.getText().toString();
                String carModel = edtTxtViewCarModel.getText().toString();
                int carYear = Integer.parseInt(edtTxtViewCarYear.getText().toString());

                AutoModel autoModel = new AutoModel(ID, carBrand, carModel, carYear);
                MyDBHelper myDBHelper = new MyDBHelper(getApplicationContext());
                boolean success = myDBHelper.updateAutoRecord(autoModel);

                if (success) {
                    Toast.makeText(getApplicationContext(), "Updated "  + carBrand, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Update failed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}