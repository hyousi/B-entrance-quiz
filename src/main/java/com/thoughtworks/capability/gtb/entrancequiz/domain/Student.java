package com.thoughtworks.capability.gtb.entrancequiz.domain;

public class Student {

    private Integer id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", id, name);
    }
}
