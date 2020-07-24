package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.ClassStudentAssignment;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
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

    public List<ClassStudentAssignment> readClassAssignments(int code) throws IdNotFoundException {
        List<ClassStudentAssignment> classAssignments = classStudentAssignmentList.stream()
                .filter(classStudentAssignment -> classStudentAssignment.getCode() == code)
                .collect(Collectors.toList());
        if (!classAssignments.isEmpty()){
            return classAssignments;
        } else {
            throw new IdNotFoundException("Class with ID " + code);
        }
    }

    public List<ClassStudentAssignment> readStudentsAssignments(int studentId) throws IdNotFoundException {
        List<ClassStudentAssignment> studentAssignments = classStudentAssignmentList.stream()
                .filter(classStudentAssignment -> classStudentAssignment.getStudentId() == studentId)
                .collect(Collectors.toList());
        if(!studentAssignments.isEmpty()){
            return studentAssignments;
        } else {
            throw new IdNotFoundException("Student with ID " + studentId);
        }
    }

}
