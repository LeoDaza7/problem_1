package com.truextend.problem_1.services;

import com.truextend.problem_1.DAOs.StudentDAO;
import com.truextend.problem_1.entities.Student;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    @Autowired
    private final StudentDAO studentDAO;

    public Student createStudent(Student student) throws IdRepeatedException {
        return studentDAO.createStudent(student);
    }

    public List<Student> readStudentAll(){
        return studentDAO.readStudentAll();
    }

    public Student readStudent(int studentId) throws IdNotFoundException {
        return studentDAO.readStudent(studentId);
    }

    public Student updateStudent(Student student, int studentId) throws IdNotFoundException {
        return studentDAO.updateStudent(student, studentId);
    }

    public void deleteStudent(int studentId) throws IdNotFoundException {
        studentDAO.deleteStudent(studentId);
    }

}
