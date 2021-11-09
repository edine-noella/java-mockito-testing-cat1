package com.example.junittest.models;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private Integer id;

    private String names;

    private String gender;

    public Student() {
    }

    public Student(String names, String gender) {
        this.names = names;
        this.gender = gender;
    }

    public Student(Integer id, String names, String gender) {
        this.id = id;
        this.names = names;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
