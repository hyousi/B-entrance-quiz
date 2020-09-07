package com.thoughtworks.capability.gtb.entrancequiz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.junit.jupiter.api.Test;

public class StudentRepositoryTest {

    @Test
    void shouldSetupStudentRepository() {
        StudentRepository studentRepository = new StudentRepository();
        assertEquals(35, studentRepository.size());
    }
}
