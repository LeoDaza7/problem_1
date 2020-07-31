package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.AssignmentCourseStudent;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentCourseStudentService {

    public List<AssignmentCourseStudent> classStudentAssignmentList = new ArrayList<>(
            Arrays.asList(
                    new AssignmentCourseStudent(0, StudentService.studentList.get(0), CourseService.courseList.get(1)),
                    new AssignmentCourseStudent(1, StudentService.studentList.get(1), CourseService.courseList.get(1))
            )
    );

    public List<AssignmentCourseStudent> readAllCourseStudentAssignments() {
        return classStudentAssignmentList;
    }

    public AssignmentCourseStudent createAssignmentCourseStudent(AssignmentCourseStudent newAssignment) throws IdRepeatedException {
        if(classStudentAssignmentList.stream().anyMatch(assignmentOnList -> assignmentOnList.getAssignmentId() == newAssignment.getAssignmentId()))
            throw new IdRepeatedException("Assignment with ID " + newAssignment.getAssignmentId());
        if(classStudentAssignmentList.stream().anyMatch(assignmentOnList -> assignmentOnList.getCourse().getCode() == newAssignment.getCourse().getCode() &&
                assignmentOnList.getStudent().getStudentID() == newAssignment.getStudent().getStudentID()))
            throw new IdRepeatedException("Student with ID " + newAssignment.getStudent().getStudentID());
        classStudentAssignmentList.add(newAssignment);
        return newAssignment;
    }

    public List<AssignmentCourseStudent> readCourseAssignments(int code) throws IdNotFoundException {
        List<AssignmentCourseStudent> courseAssignments = classStudentAssignmentList.stream()
                .filter(courseStudentAssignment -> courseStudentAssignment.getCourse().getCode() == code)
                .collect(Collectors.toList());
        if (!courseAssignments.isEmpty()){
            return courseAssignments;
        } else {
            throw new IdNotFoundException("Course with ID " + code);
        }
    }

    public List<AssignmentCourseStudent> readStudentsAssignments(int studentId) throws IdNotFoundException {
        List<AssignmentCourseStudent> studentAssignments = classStudentAssignmentList.stream()
                .filter(courseStudentAssignment -> courseStudentAssignment.getStudent().getStudentID() == studentId)
                .collect(Collectors.toList());
        if(!studentAssignments.isEmpty()){
            return studentAssignments;
        } else {
            throw new IdNotFoundException("Student with ID " + studentId);
        }
    }

}
