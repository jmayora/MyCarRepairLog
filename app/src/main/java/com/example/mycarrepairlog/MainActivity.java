package com.example.mycarrepairlog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_main);

        myCarsListView = (RecyclerView) findViewById(R.id.rvCarList);

        layoutManager = new LinearLayoutManager(this);
        myCarsListView.setLayoutManager(layoutManager);

        allAutosList = db.getAllAutos();
        autosCount = allAutosList.size();

        myAdapter = new CustomAdapter(allAutosList);
        myCarsListView.setAdapter(myAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        allAutosList = db.getAllAutos();
        myAdapter.setAllAutosList(allAutosList);
        myAdapter.notifyDataSetChanged();
    }

    public void addCar(View view){
        Toast.makeText(getApplicationContext(), "Add Car selected", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), AddCarActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()) {
            case R.id.menu_settings:
                Log.i("Item Selected: ", "Settings");
                return true;
            case R.id.menu_add:
                Log.i("Item Selected: ", "Add Car");
                return  true;
            default:
                return false;
        }
    }

}