package com.truextend.problem_1.controllers;

import com.truextend.problem_1.entities.AssignmentCourseStudent;
import com.truextend.problem_1.errors.AssignmentRepeatedException;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import com.truextend.problem_1.services.AssignmentCourseStudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignment")
@AllArgsConstructor
public class AssignmentCourseStudentController {

    @Autowired
    private final AssignmentCourseStudentService assignmentCourseStudentService;

    @GetMapping
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

    @PostMapping
    public AssignmentCourseStudent postAssignment(@RequestBody AssignmentCourseStudent newAssignment) throws IdRepeatedException, AssignmentRepeatedException, IdNotFoundException {
        return assignmentCourseStudentService.createAssignmentCourseStudent(newAssignment);
    }

}
