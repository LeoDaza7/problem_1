package com.truextend.problem_1.DAOs;

import com.truextend.problem_1.entities.AssignmentCourseStudent;
import com.truextend.problem_1.errors.AssignmentRepeatedException;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;

import java.util.List;

public interface AssignmentCourseStudentDAO {

    AssignmentCourseStudent createAssignmentCourseStudent(AssignmentCourseStudent newAssignment) throws IdRepeatedException, AssignmentRepeatedException, IdNotFoundException;
    List<AssignmentCourseStudent> readAllCourseStudentAssignments();
    List<AssignmentCourseStudent> readCourseAssignments(int code) throws IdNotFoundException;
    List<AssignmentCourseStudent> readStudentsAssignments(int studentId) throws IdNotFoundException;

}
