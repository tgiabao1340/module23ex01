package com.example.student.module23_ex01;

public class Employee {
    private String id;
    private String name;
    private boolean gender;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.id +" - " + this.name;
    }
}
