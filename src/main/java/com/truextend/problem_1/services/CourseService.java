package com.truextend.problem_1.services;

import com.truextend.problem_1.DAOs.CourseDAO;
import com.truextend.problem_1.entities.Course;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    @Autowired
    private final CourseDAO courseDAO;

    public Course createCourse(Course newCourse) throws IdRepeatedException {
        return courseDAO.createCourse(newCourse);
    }

    public List<Course> readCourseAll() {
        return courseDAO.readCourseAll();
    }

    public Course readCourse(int courseCode) throws IdNotFoundException {
        return courseDAO.readCourse(courseCode);
    }

    public Course updateCourse(Course course, int courseCode) throws IdNotFoundException  {
        return courseDAO.updateCourse(course, courseCode);
    }

    public void deleteCourse(int courseCode) throws IdNotFoundException {
        courseDAO.deleteCourse(courseCode);
    }

}
