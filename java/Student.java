package com.example.demoapp;

public class Student {
    String name;
    String age;
    String country;

    public Student(String name, String age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
