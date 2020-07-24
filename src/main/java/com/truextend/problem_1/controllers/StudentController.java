package com.truextend.problem_1.controllers;

import com.truextend.problem_1.entities.Student;
import com.truextend.problem_1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudentList(){
        return studentService.readStudentAll();
    }

    @PostMapping("/student")
    public Student postStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/student/{id}")
    public Student putStudent(@RequestBody Student student, @PathVariable(value = "id") int studentId) {
        return studentService.updateStudent(student, studentId);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable(value = "id") int studentId) {
        studentService.deleteStudent(studentId);
    }

}
