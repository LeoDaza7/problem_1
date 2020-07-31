package com.truextend.problem_1.controllers;

import com.truextend.problem_1.entities.AssignmentCourseStudent;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.services.AssignmentCourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentCourseStudentController {

    @Autowired
    private AssignmentCourseStudentService assignmentCourseStudentService;

    @GetMapping("")
    public List<AssignmentCourseStudent> getAllAssignments() {
        return assignmentCourseStudentService.readAllCourseStudentAssignments();
    }

    @GetMapping("/student/{id}")
    public List<AssignmentCourseStudent> getStudentAssignments(@PathVariable(value = "id") int studentId) throws IdNotFoundException {
        return assignmentCourseStudentService.readStudentsAssignments(studentId);
    }

    @GetMapping("/course/{id}")
    public List<AssignmentCourseStudent> getCourseAssignments(@PathVariable(value = "id") int code) throws IdNotFoundException {
        return assignmentCourseStudentService.readCourseAssignments(code);
    }

}
