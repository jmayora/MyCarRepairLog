package com.example.mycarrepairlog;

public class AutoModel {

    private int ID;
    private String brand;
    private String model;
    private int year;
    private String chassis;
    private String license;
    private String insurance;
    private String last_maintenance_date;
    private int last_kilometers;

    public AutoModel(String brand, String model, int year, String chassis, String license, String insurance) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.chassis = chassis;
        this.license = license;
        this.insurance = insurance;
    }

    public AutoModel(int ID, String brand, String model, int year, String chassis, String license, String insurance) {
        this.ID = ID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.chassis = chassis;
        this.license = license;
        this.insurance = insurance;
    }

    public AutoModel(int ID, String brand, String model, int year, String chassis, String license, String insurance, String last_maintenance_date, int last_kilometers) {
        this.ID = ID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.chassis = chassis;
        this.license = license;
        this.insurance = insurance;
        this.last_maintenance_date = last_maintenance_date;
        this.last_kilometers = last_kilometers;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getLast_maintenance_date() {
        return last_maintenance_date;
    }

    public void setLast_maintenance_date(String last_maintenance_date) {
        this.last_maintenance_date = last_maintenance_date;
    }

    public int getLast_kilometers() {
        return last_kilometers;
    }

    public void setLast_kilometers(int last_kilometers) {
        this.last_kilometers = last_kilometers;
    }



    @Override
    public String toString() {
        return "AutoModel{" +
                "ID=" + ID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", chassis='" + chassis + '\'' +
                ", license='" + license + '\'' +
                ", insurance='" + insurance + '\'' +
                ", last_maintenance_date='" + last_maintenance_date + '\'' +
                ", last_kilometers=" + last_kilometers +
                '}';
    }
}
