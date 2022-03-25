package com.example.demoapp;

import java.util.List;

public class Class {
    private String class_name;
    private List<Student> students;
    boolean isExpanded = false;

    public Class(String class_name, List<Student> students) {
        this.class_name = class_name;
        this.students = students;
    }

    public String getClass_name() {
        return class_name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
