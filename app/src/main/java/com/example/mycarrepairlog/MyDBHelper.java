package com.example.mycarrepairlog;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "AutosDB";
    public static final String TBL_AUTOS = "Autos";
    public static final int DB_VERSION = 1;
    public static final String AUTO_TABLE = "AUTO_TABLE";
    public static final String COLUMN_ID = "COLUMN_ID";
    public static final String COLUMN_BRAND = "COLUMN_BRAND";
    public static final String COLUMN_MODEL = "COLUMN_MODEL";
    public static final String COLUMN_YEAR = "COLUMN_YEAR";
    public static final String COLUMN_KILOMETERS = "COLUMN_KILOMETERS";


    public MyDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTableStatement = "CREATE TABLE " + AUTO_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_BRAND + " TEXT, " + COLUMN_MODEL + " TEXT, " + COLUMN_YEAR + " INT, " + COLUMN_KILOMETERS + " FLOAT )";

    db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean addOne(AutoModel autoModel){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BRAND, autoModel.getBrand());
        cv.put(COLUMN_MODEL, autoModel.getModel());
        cv.put(COLUMN_YEAR, autoModel.getYear());
        cv.put(COLUMN_KILOMETERS, autoModel.getKilometers());

        long result = db.insert(AUTO_TABLE, null, cv);

        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }
}
