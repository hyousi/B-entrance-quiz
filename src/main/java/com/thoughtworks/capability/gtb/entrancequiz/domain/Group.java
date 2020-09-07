package com.thoughtworks.capability.gtb.entrancequiz.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.lang.NonNull;

public class Group {

    private Integer id;
    private List<Student> students;
    @NonNull
    private String name;

    public Group(int id) {
        this.id = id;
        this.students = new ArrayList<>();
        this.name = String.format("Team %d", id);
    }

    public void add(Student student) {
        this.students.add(student);
    }

    public void clear() {
        this.students.clear();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(
        List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Group group = (Group) o;

        return name.equals(group.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
