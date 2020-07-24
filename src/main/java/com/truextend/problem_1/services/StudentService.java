package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentService {

    private List<Student> studentList = new ArrayList<>(
            Arrays.asList(
                    new Student(0,"Wilson","John"),
                    new Student(1,"Graham","Jane"),
                    new Student(2,"Wilson","John")
            )
    );

}
