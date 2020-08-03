package com.truextend.problem_1.controllers;

import com.truextend.problem_1.entities.Student;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import com.truextend.problem_1.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudentList(){
        return studentService.readStudentAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(value = "id") int studentId) throws IdNotFoundException {
        return studentService.readStudent(studentId);
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student) throws IdRepeatedException {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student putStudent(@RequestBody Student student, @PathVariable(value = "id") int studentId) throws IdNotFoundException {
        return studentService.updateStudent(student, studentId);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(value = "id") int studentId) throws IdNotFoundException {
        studentService.deleteStudent(studentId);
    }

}
