package com.truextend.problem_1.DAOs;

import com.truextend.problem_1.entities.Course;
import com.truextend.problem_1.entities.Student;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;

import java.util.List;

public interface StudentDAO {

    Student createStudent(Student student) throws IdRepeatedException;
    List<Student> readStudentAll();
    Student readStudent(int id) throws IdNotFoundException;
    Student updateStudent(Student student, int studentId) throws IdNotFoundException;
    void deleteStudent(int id) throws IdNotFoundException;

}
