package com.truextend.problem_1.DAOs;

import com.truextend.problem_1.entities.Course;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;

import java.util.List;

public interface CourseDAO {

    Course createCourse(Course course) throws IdRepeatedException;
    List<Course> readCourseAll();
    Course readCourse(int id) throws IdNotFoundException;
    Course updateCourse(Course course, int code) throws IdNotFoundException;
    void deleteCourse(int id) throws IdNotFoundException;

}
