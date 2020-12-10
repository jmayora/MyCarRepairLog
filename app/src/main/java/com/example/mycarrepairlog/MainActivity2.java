package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    Button btnAdd2;

    MyDBHelper db = new MyDBHelper(this);
    List<AutoModel> allAutosList;
    ArrayList<String> myCarsList = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    RecyclerView myCarsListView;
    LinearLayoutManager layoutManager;
    CustomAdapter myAdapter;
    int autosCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myCarsListView = (RecyclerView) findViewById(R.id.rvCarList);
        btnAdd2 = findViewById(R.id.btnAdd2);


        layoutManager = new LinearLayoutManager(this);
        myCarsListView.setLayoutManager(layoutManager);

        allAutosList = db.getAllAutos();
        autosCount = allAutosList.size();

        myAdapter = new CustomAdapter(allAutosList);
        myCarsListView.setAdapter(myAdapter);



    }
}