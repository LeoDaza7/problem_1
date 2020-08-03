package com.truextend.problem_1.services;

import com.truextend.problem_1.DAOs.AssignmentCourseStudentDAO;
import com.truextend.problem_1.entities.AssignmentCourseStudent;
import com.truextend.problem_1.errors.AssignmentRepeatedException;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AssignmentCourseStudentService {

    @Autowired
    private final AssignmentCourseStudentDAO assignmentCourseStudentDAO;

    public List<AssignmentCourseStudent> readAllCourseStudentAssignments() {
        return assignmentCourseStudentDAO.readAllCourseStudentAssignments();
    }

    public AssignmentCourseStudent createAssignmentCourseStudent(AssignmentCourseStudent newAssignment) throws IdRepeatedException, AssignmentRepeatedException, IdNotFoundException {
        return assignmentCourseStudentDAO.createAssignmentCourseStudent(newAssignment);
    }

    public List<AssignmentCourseStudent> readCourseAssignments(int code) throws IdNotFoundException {
        return assignmentCourseStudentDAO.readCourseAssignments(code);
    }

    public List<AssignmentCourseStudent> readStudentsAssignments(int studentId) throws IdNotFoundException {
        return assignmentCourseStudentDAO.readStudentsAssignments(studentId);
    }

}
