package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private List<Student> studentList;

    public StudentRepository() {
        studentList = new ArrayList<>();
        String content = "1\n"
            + "沈乐棋\n"
            + "2\n"
            + "徐慧慧\n"
            + "3\n"
            + "陈思聪\n"
            + "4\n"
            + "王江林\n"
            + "5\n"
            + "王登宇\n"
            + "6\n"
            + "杨思雨\n"
            + "7\n"
            + "江雨舟\n"
            + "8\n"
            + "廖燊\n"
            + "9\n"
            + "胡晓\n"
            + "10\n"
            + "但杰\n"
            + "11\n"
            + "盖迈达\n"
            + "12\n"
            + "肖美琦\n"
            + "13\n"
            + "黄云洁\n"
            + "14\n"
            + "齐瑾浩\n"
            + "15\n"
            + "刘亮亮\n"
            + "16\n"
            + "肖逸凡\n"
            + "17\n"
            + "王作文\n"
            + "18\n"
            + "郭瑞凌\n"
            + "19\n"
            + "李明豪\n"
            + "20\n"
            + "党泽\n"
            + "21\n"
            + "肖伊佐\n"
            + "22\n"
            + "贠晨曦\n"
            + "23\n"
            + "李康宁\n"
            + "24\n"
            + "马庆\n"
            + "25\n"
            + "商婕\n"
            + "26\n"
            + "余榕\n"
            + "27\n"
            + "谌哲\n"
            + "28\n"
            + "董翔锐\n"
            + "29\n"
            + "陈泰宇\n"
            + "30\n"
            + "赵允齐\n"
            + "31\n"
            + "张柯\n"
            + "32\n"
            + "廖文强\n"
            + "33\n"
            + "刘轲\n"
            + "34\n"
            + "廖浚斌\n"
            + "35\n"
            + "凌凤仪\n";
        String[] lines = content.split("\n");
        for (int i = 0; i < lines.length; i+=2) {
            int id = Integer.parseInt(lines[i]);
            String name = lines[i+1];
            Student student = new Student(id, name);
            studentList.add(student);
        }
    }

    public int size() {
        return studentList.size();
    }

    public void add(Student student) {
        if (student.getId() == null || student.getId() == 0) {
            student.setId(size() + 1);
        }
        studentList.add(student);
    }

    public List<Student> findAll() {
        return studentList;
    }
}
