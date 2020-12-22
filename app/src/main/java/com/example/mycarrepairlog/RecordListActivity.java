package com.example.mycarrepairlog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecordListActivity extends AppCompatActivity {
    MyDBHelper db = new MyDBHelper(this);
    List<LogRecordModel> allLogRecordList;
    ArrayList<String> myLogList = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    RecyclerView myLogListView;
    LinearLayoutManager layoutManager;
    LogListAdapter myAdapter;
    int logRecordsCount;
    int auto_ID;
    String auto_Brand;
    String auto_Model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);

        Button btnAddRecord = findViewById(R.id.btnAddRecord);
        auto_ID = getIntent().getIntExtra("ID", 1);
        auto_Brand = getIntent().getStringExtra("autoBrand");
        auto_Model = getIntent().getStringExtra("autoModel");

        myLogListView = (RecyclerView) findViewById(R.id.rvLogList);

        layoutManager = new LinearLayoutManager(this);
        myLogListView.setLayoutManager(layoutManager);

        allLogRecordList = db.getAllLogRecords(auto_ID);
        logRecordsCount = allLogRecordList.size();

        myAdapter = new LogListAdapter(allLogRecordList);
        myLogListView.setAdapter(myAdapter);

    }
    @Override
    protected void onResume() {
        super.onResume();
        allLogRecordList = db.getAllLogRecords(auto_ID);
        myAdapter.setAllLogRecordList(allLogRecordList);
        myAdapter.notifyDataSetChanged();
    }
    public void addLogRecord(View view){
        Toast.makeText(getApplicationContext(), "Add Record selected", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(view.getContext(), AddRecordActivity.class);
        intent.putExtra("auto_ID", auto_ID);
        intent.putExtra("autoBrand", auto_Brand);
        intent.putExtra("autoModel", auto_Model);
        startActivity(intent);
    }

}