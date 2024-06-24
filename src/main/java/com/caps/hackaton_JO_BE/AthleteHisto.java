package com.caps.hackaton_JO_BE;

import com.opencsv.bean.CsvBindByName;

public class AthleteHisto {

        @CsvBindByName(column = "PLACE")
        private String place;

        @CsvBindByName(column = "NAME")
        private String name;

        @CsvBindByName(column = "BIRTH DATE")
        private String birthDate;

        @CsvBindByName(column = "NAT.")
        private String nationality;

        @CsvBindByName(column = "MARK")
        private String mark;

        @CsvBindByName(column = "COMPETITION")
        private String competition;

        @CsvBindByName(column = "RACE")
        private String race;

        private String medal;

        // getters and setters...

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getMedal() {
        return medal;
    }

    public void setMedal(String medal) {
        this.medal = medal;
    }
}
