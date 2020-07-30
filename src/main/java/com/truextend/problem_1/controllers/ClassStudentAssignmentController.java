package com.truextend.problem_1.controllers;

import com.truextend.problem_1.entities.ClassStudentAssignment;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.services.ClassStudentAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassStudentAssignmentController {

    @Autowired
    private ClassStudentAssignmentService classStudentAssignmentService;

    @GetMapping("/student/assignments/{id}")
    public List<ClassStudentAssignment> getStudentAssignments(@PathVariable(value = "id") int studentId) throws IdNotFoundException {
        return classStudentAssignmentService.readStudentsAssignments(studentId);
    }

    @GetMapping("/class/assignments/{id}")
    public List<ClassStudentAssignment> getClassAssignments(@PathVariable(value = "id") int code) throws IdNotFoundException {
        return classStudentAssignmentService.readClassAssignments(code);
    }

}
