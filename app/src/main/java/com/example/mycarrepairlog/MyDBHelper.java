package com.example.mycarrepairlog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class MyDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "AutosDB";
    public static final String TBL_AUTOS = "Autos";
    public static final int DB_VERSION = 1;
    public static final String AUTO_TABLE = "AUTO_TABLE";
    public static final String COLUMN_ID = "COLUMN_ID";
    public static final String COLUMN_BRAND = "COLUMN_BRAND";
    public static final String COLUMN_MODEL = "COLUMN_MODEL";
    public static final String COLUMN_YEAR = "COLUMN_YEAR";
    public static final String COLUMN_CHASSIS = "COLUMN_CHASSIS";
    public static final String COLUMN_LICENSE = "COLUMN_LICENSE";
    public static final String COLUMN_INSURANCE = "COLUMN_INSURANCE";

    public static final String LOG_TABLE = "LOG_TABLE";
    public static final String COLUMN_LOG_DETAIL = "COLUMN_LOG_DETAIL";
    public static final String COLUMN_LOG_DATE1 = "COLUMN_LOG_DATE1";
    public static final String COLUMN_LOG_DATE2 = "COLUMN_LOG_DATE2";
    public static final String COLUMN_LOG_KILOMETERS1 = "COLUMN_LOG_KILOMETERS1";
    public static final String COLUMN_LOG_KILOMETERS2 = "COLUMN_LOG_KILOMETERS2";


    public MyDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTableStatement1 = "CREATE TABLE " + AUTO_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_BRAND + " TEXT, " + COLUMN_MODEL + " TEXT, " + COLUMN_YEAR + " INT, " + COLUMN_CHASSIS + " TEXT, "+
            COLUMN_LICENSE + " TEXT, " + COLUMN_INSURANCE + " TEXT, " +
            COLUMN_LOG_DATE1 + " TEXT, " + COLUMN_LOG_KILOMETERS1 + " INT)";

    String createTableStatement2 = "CREATE TABLE " + LOG_TABLE + " (" + COLUMN_ID + " INTEGER, " + COLUMN_LOG_DATE1 + " TEXT, " +
            COLUMN_LOG_DATE2 + " TEXT, " + COLUMN_LOG_DETAIL + " TEXT, " + COLUMN_LOG_KILOMETERS1 + " INT, " +
            COLUMN_LOG_KILOMETERS2 + " INT)";

    db.execSQL(createTableStatement1);
    db.execSQL(createTableStatement2);

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

        long result = db.insert(AUTO_TABLE, null, cv);

        if (result == -1) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }

    public boolean updateAutoRecord(AutoModel autoModel){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BRAND, autoModel.getBrand());
        cv.put(COLUMN_MODEL, autoModel.getModel());
        cv.put(COLUMN_YEAR, autoModel.getYear());
        String where = "COLUMN_ID = ?";

        long result = db.update(AUTO_TABLE, cv, where, new String[]{valueOf(autoModel.getID())});
        if (result == -1) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }

    public boolean addLogRecord(LogRecordModel logRecordModel){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID, logRecordModel.getID());
        cv.put(COLUMN_LOG_DETAIL, logRecordModel.getDetail());
        cv.put(COLUMN_LOG_DATE1, logRecordModel.getDate1());
        cv.put(COLUMN_LOG_DATE2, logRecordModel.getDate2());
        cv.put(COLUMN_LOG_KILOMETERS1, logRecordModel.getKilometers1());
        cv.put(COLUMN_LOG_KILOMETERS2, logRecordModel.getKilometers2());

        long result = db.insert(LOG_TABLE, null, cv);

        if (result == -1) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }

    public boolean deleteOne(int autoID){
        return true;
    }


    public List<AutoModel> getAllAutos() {
        List<AutoModel> allAutosList = new ArrayList<>();

        String selectAllAutos = "SELECT * FROM " + AUTO_TABLE;

        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery(selectAllAutos,null);

        if(c.moveToFirst()){
            do {
                int ID = c.getInt(0);
                String autoBrand = c.getString(1);
                String autoModel = c.getString(2);
                int autoYear = c.getInt(3);

                AutoModel auto = new AutoModel(ID, autoBrand, autoModel, autoYear);
                allAutosList.add(auto);

            } while (c.moveToNext());
        } else {

        }
        c.close();
        db.close();
        return allAutosList;
        
    }

    public List<LogRecordModel> getAllLogRecords( int auto_ID){

        Log.d("getAllLogRecords", "auto ID = "+ auto_ID);
        List<LogRecordModel> allLogRecordsList = new ArrayList<>();

        String selectAllLogRecords = "SELECT * FROM " + LOG_TABLE + " WHERE " +
                COLUMN_ID + " = " + auto_ID;
        Log.d("getAllLogRecords", "Select string = " + selectAllLogRecords);
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery(selectAllLogRecords,null);

        if(c.moveToFirst()){
            do {
                int ID = c.getInt(0);
                String date1 = c.getString(1);
                String date2 = c.getString(2);
                String detail = c.getString(3);
                int kilometers1 = c.getInt(4);
                int kilometers2 = c.getInt(5);


                LogRecordModel logRecord = new LogRecordModel(ID, kilometers1, kilometers2 , detail, date1, date2);
                allLogRecordsList.add(logRecord);

            } while (c.moveToNext());
        } else {

        }
        c.close();
        db.close();
        return allLogRecordsList;
    }
}
