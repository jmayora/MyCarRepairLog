package com.example.mycarrepairlog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ListView myCarsListView;
    Button btnAddCar;

    MyDBHelper db = new MyDBHelper(this);
    List<AutoModel> allAutosList;
    ArrayList<String> myCarsList = new ArrayList<>();
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCarsListView = findViewById(R.id.listViewCars);
        btnAddCar = findViewById(R.id.btnAddCar);

        allAutosList = db.getAllAutos();
        for (int i = 0; i < allAutosList.size(); i++)
            myCarsList.add(allAutosList.get(i).getBrand() + " " + allAutosList.get(i).getModel() + " " + allAutosList.get(i).getYear());

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myCarsList);

        myCarsListView.setAdapter(arrayAdapter);

        myCarsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String selection = myCarsListView.getItemAtPosition(i).toString();
                String[] arrOfStr = selection.split(" ");
                String autoBrand = arrOfStr[0];
                String autoModel = arrOfStr[1];
                String autoYear = arrOfStr[2];

                Toast.makeText(getApplicationContext(), "Hello " + autoBrand + " , " + autoModel + " , " + autoYear, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), RecordListActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        allAutosList = db.getAllAutos();
        myCarsList.clear();
        for (int i = 0; i < allAutosList.size(); i++)
            myCarsList.add(allAutosList.get(i).getBrand() + " " + allAutosList.get(i).getModel() + " " + allAutosList.get(i).getYear());
        arrayAdapter.notifyDataSetChanged();
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