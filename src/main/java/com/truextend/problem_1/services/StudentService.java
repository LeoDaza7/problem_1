package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.Student;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    public static List<Student> studentList = new ArrayList<>(
            Arrays.asList(
                    new Student(0,"Wilson","John"),
                    new Student(1,"Graham","Jane"),
                    new Student(2,"Bam","Pam")
            )
    );

    public Student createStudent(Student student) throws IdRepeatedException {
        if (studentList.stream().noneMatch(studentStream -> studentStream.getStudentID() == student.getStudentID())){
            studentList.add(student);
            return student;
        } else {
            throw new IdRepeatedException("Student with ID " + student.getStudentID());
        }

    }

    public List<Student> readStudentAll(){
        return studentList;
    }

    public Student readStudent(int studentId) throws IdNotFoundException {
        List<Student> currentStudent = studentList.stream().filter(student -> student.getStudentID() == studentId).collect(Collectors.toList());
        if (!currentStudent.isEmpty()) {
            return currentStudent.get(0);
        } else {
            throw new IdNotFoundException("Student with ID " + studentId);
        }
    }

    public Student updateStudent(Student student, int studentId) throws IdNotFoundException {
        List<Student> currentStudent = studentList.stream().filter(studentStream -> studentStream.getStudentID() == studentId).collect(Collectors.toList());
        if (!currentStudent.isEmpty()) {
            currentStudent.get(0).setFirstName(student.getFirstName());
            currentStudent.get(0).setLastName(student.getLastName());
            return student;
        } else {
            throw new IdNotFoundException("Student with ID " + student.getStudentID());
        }

    }

    public void deleteStudent(int studentId) throws IdNotFoundException {
        if(!studentList.removeIf(student -> student.getStudentID() == studentId))
            throw new IdNotFoundException("Student with ID " + studentId);
    }

}
