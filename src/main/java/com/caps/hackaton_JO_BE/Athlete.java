package com.caps.hackaton_JO_BE;

import com.opencsv.bean.CsvBindByName;

public class Athlete {

    @CsvBindByName(column = "Athlète")
    private String name;

    @CsvBindByName(column = "Sexe")
    private String gender;

    @CsvBindByName(column = "Pays")
    private String country;

    @CsvBindByName(column = "Discipline")
    private String discipline;

    @CsvBindByName(column = "Year")
    private int year;

    @CsvBindByName(column = "Position")
    private double position;

    @CsvBindByName(column = "Temps")
    private String time;

    @CsvBindByName(column = "Note")
    private String note;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}