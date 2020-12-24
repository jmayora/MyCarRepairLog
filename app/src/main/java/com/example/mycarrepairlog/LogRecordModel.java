package com.example.mycarrepairlog;

import java.sql.Date;

public class LogRecordModel {

    int ID, kilometers;
    String detail, date;

    @Override
    public String toString() {
        return "LogRecordModel{" +
                "ID=" + ID +
                ", kilometers=" + kilometers +
                ", detail='" + detail + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public LogRecordModel(int ID, String date, int kilometers, String detail) {
        this.ID = ID;
        this.kilometers = kilometers;
        this.detail = detail;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
