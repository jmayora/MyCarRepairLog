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
    public static final String COLUMN_LAST_MAINTENANCE_DATE = "COLUMN_LAST_MAINTENANCE_DATE";
    public static final String COLUMN_LAST_KILOMETERS = "COLUMN_LAST_KILOMETERS";

    public static final String LOG_TABLE = "LOG_TABLE";
    public static final String COLUMN_LOG_DETAIL = "COLUMN_LOG_DETAIL";
    public static final String COLUMN_LOG_DATE = "COLUMN_LOG_DATE";
    public static final String COLUMN_LOG_KILOMETERS = "COLUMN_LOG_KILOMETERS";


    public MyDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String createTableStatement1 = "CREATE TABLE " + AUTO_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_BRAND + " TEXT, " + COLUMN_MODEL + " TEXT, " + COLUMN_YEAR + " INTEGER, " + COLUMN_CHASSIS + " TEXT, "+
            COLUMN_LICENSE + " TEXT, " + COLUMN_INSURANCE + " TEXT, " +
            COLUMN_LAST_MAINTENANCE_DATE + " TEXT, " + COLUMN_LAST_KILOMETERS + " INTEGER)";

    String createTableStatement2 = "CREATE TABLE " + LOG_TABLE + " (" + COLUMN_ID + " INTEGER, " + COLUMN_LOG_DATE + " TEXT, " +
            COLUMN_LOG_KILOMETERS + " INTEGER, " + COLUMN_LOG_DETAIL + " TEXT)" ;

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
        cv.put(COLUMN_CHASSIS, autoModel.getChassis());
        cv.put(COLUMN_LICENSE, autoModel.getLicense());
        cv.put(COLUMN_INSURANCE, autoModel.getInsurance());

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
        cv.put(COLUMN_CHASSIS, autoModel.getChassis());
        cv.put(COLUMN_LICENSE, autoModel.getLicense());
        cv.put(COLUMN_INSURANCE, autoModel.getInsurance());

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
        cv.put(COLUMN_LOG_DATE, logRecordModel.getDate());
        cv.put(COLUMN_LOG_KILOMETERS, logRecordModel.getKilometers());

        long result = db.insert(LOG_TABLE, null, cv);

        if (result == -1) {

            db.close();
            return false;
        } else {
            db.close();
            return true;
        }
    }

    public boolean updateLogRecord(LogRecordModel logRecordModel){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_LOG_DETAIL, logRecordModel.getDetail());
        cv.put(COLUMN_LOG_DATE, logRecordModel.getDate());
        cv.put(COLUMN_LOG_KILOMETERS, logRecordModel.getKilometers());

        String where = "COLUMN_ID = ?";

        long result = db.update(LOG_TABLE, cv, where, new String[]{valueOf(logRecordModel.getID())});
        if (result == -1) {
            db.close();
            return false;
        } else {
            db.close();
            return true;
        }

    }

    public boolean updateAutoMaintenanceData(LogRecordModel logRecordModel){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_LAST_MAINTENANCE_DATE, logRecordModel.getDate());
        cv.put(COLUMN_LAST_KILOMETERS, logRecordModel.getKilometers());


        String where = "COLUMN_ID = ?";

        long result = db.update(AUTO_TABLE, cv, where, new String[]{valueOf(logRecordModel.getID())});
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
                String chassis = c.getString(4);
                String license = c.getString(5);
                String insurance = c. getString(6);
                String last_maintenance_date = c.getString(7);
                int last_kilometers = c.getInt(8);

                AutoModel auto = new AutoModel(ID, autoBrand, autoModel, autoYear, chassis, license, insurance, last_maintenance_date, last_kilometers);
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
                String date = c.getString(1);
                int kilometers = c.getInt(2);
                String detail = c.getString(3);


                LogRecordModel logRecord = new LogRecordModel(ID, date , kilometers, detail);
                allLogRecordsList.add(logRecord);

            } while (c.moveToNext());
        } else {

        }
        c.close();
        db.close();
        return allLogRecordsList;
    }
}
