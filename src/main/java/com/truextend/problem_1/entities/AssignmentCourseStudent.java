package com.truextend.problem_1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentCourseStudent {

    private int assignmentId;
    private Student student;
    private Course course;

}
