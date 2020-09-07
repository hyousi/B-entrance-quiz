package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:1234")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/api/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/api/students")
    public void addStudent(@RequestBody Student student) {
        studentRepository.add(student);
    }

}
