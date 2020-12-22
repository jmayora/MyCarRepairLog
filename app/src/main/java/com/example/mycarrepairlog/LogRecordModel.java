package com.example.mycarrepairlog;

import java.sql.Date;

public class LogRecordModel {

    int ID, Kilometers1, Kilometers2;
    String Detail, Date1, Date2;

    public LogRecordModel(int ID, int kilometers1, int kilometers2, String detail, String date1, String date2) {
        this.ID = ID;
        Kilometers1 = kilometers1;
        Kilometers2 = kilometers2;
        Detail = detail;
        Date1 = date1;
        Date2 = date2;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getKilometers1() {
        return Kilometers1;
    }

    public void setKilometers1(int kilometers1) {
        Kilometers1 = kilometers1;
    }

    public int getKilometers2() {
        return Kilometers2;
    }

    public void setKilometers2(int kilometers2) {
        Kilometers2 = kilometers2;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String date1) {
        Date1 = date1;
    }

    public String getDate2() {
        return Date2;
    }

    public void setDate2(String date2) {
        Date2 = date2;
    }

    @Override
    public String toString() {
        return "LogRecord{" +
                "ID=" + ID +
                ", Kilometers1=" + Kilometers1 +
                ", Kilometers2=" + Kilometers2 +
                ", Detail='" + Detail + '\'' +
                ", Date1=" + Date1 +
                ", Date2=" + Date2 +
                '}';
    }
}
