package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepository {

    private static final int GROUPS = 6;

    @Autowired
    StudentRepository studentRepository;

    List<Group> groupList = new ArrayList<>();

    GroupRepository() {
        for (int i = 1; i <= GROUPS; i++) {
            groupList.add(new Group(i));
        }
    }

    public List<Group> findAll() {
        List<Student> studentList = studentRepository.findAll();
        Collections.shuffle(studentList);

        for (Group group : groupList) {
            group.clear();
        }

        int index = 0;
        for (Student student : studentList) {
            groupList.get(index).add(student);
            index = (index + 1) % GROUPS;
        }

        return groupList;
    }

    public Group findGroupById(int id) {
        return groupList.stream().filter(group -> group.getId() == id).findFirst().orElse(null);
    }

    public Group findGroupByName(String name) {
        return groupList.stream().filter(group -> group.getName().equals(name)).findAny().orElse(null);
    }
}
