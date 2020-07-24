package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.ClassStudentAssignment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassStudentAssignmentService {

    List<ClassStudentAssignment> classStudentAssignmentList = new ArrayList<>(
            Arrays.asList(
                    new ClassStudentAssignment(0,1),
                    new ClassStudentAssignment(1,1),
                    new ClassStudentAssignment(2,1),
                    new ClassStudentAssignment(0,2),
                    new ClassStudentAssignment(1,3),
                    new ClassStudentAssignment(2,4)
            )
    );

    public List<ClassStudentAssignment> readAllAssignments() {
        return classStudentAssignmentList;
    }

    public List<ClassStudentAssignment> readClassAssignments(int code) {
        return classStudentAssignmentList.stream()
                .filter(classStudentAssignment -> classStudentAssignment.getCode() == code)
                .collect(Collectors.toList());
    }

    public List<ClassStudentAssignment> readStudentsAssignments(int studentId) {
        return classStudentAssignmentList.stream()
                .filter(classStudentAssignment -> classStudentAssignment.getStudentId() == studentId)
                .collect(Collectors.toList());
    }

}
