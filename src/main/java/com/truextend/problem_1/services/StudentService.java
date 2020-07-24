package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private List<Student> studentList = new ArrayList<>(
            Arrays.asList(
                    new Student(0,"Wilson","John"),
                    new Student(1,"Graham","Jane"),
                    new Student(2,"Bam","Pam")
            )
    );

    public Student createStudent(Student student) {
        studentList.add(student);
        return student;
    }

    public List<Student> readStudentAll(){
        return studentList;
    }

    public Student readStudent(int studentId) {
        return studentList.stream().filter(student -> student.getStudentID() == studentId).collect(Collectors.toList()).get(0);
    }

    public Student updateStudent(Student student, int studentId) {
        studentList.stream().filter(studentStream -> studentStream.getStudentID() == studentId).collect(Collectors.toList()).set(0,student);
        return student;
    }

    public void deleteStudent(int studentId) {
        studentList.removeIf(student -> student.getStudentID() == studentId);
    }

}
