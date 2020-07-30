package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.Course;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private List<Course> courseList = new ArrayList<>(
            Arrays.asList(
                    new Course(1,"Introductory Psycho biology","virtual course"),
                    new Course(2,"Art of Listening","virtual course"),
                    new Course(3,"Art History","virtual course"),
                    new Course(4,"Principles of computational geo-location analysis","virtual course")
            )
    );

    public Course createCourse(Course newCourse) throws IdRepeatedException {
        if (courseList.stream().anyMatch(courseOnList -> courseOnList.getCode() == newCourse.getCode()))
            throw new IdRepeatedException("Course with ID " + newCourse.getCode());
        return newCourse;
    }

    public List<Course> readCourseAll() {
        return courseList;
    }

    public Course readCourse(int courseCode) throws IdNotFoundException {
        List<Course> currentCourses = courseList.stream().filter(courseOnList -> courseOnList.getCode() == courseCode).collect(Collectors.toList());
        if (currentCourses.isEmpty())
            throw new IdNotFoundException("Course with ID " + courseCode);
        return currentCourses.get(0);
    }

    public Course updateCourse(Course course, int courseCode ) throws IdNotFoundException  {
        List<Course> currentCourses = courseList.stream().filter(courseOnList -> courseOnList.getCode() == courseCode).collect(Collectors.toList());
        if (currentCourses.isEmpty())
            throw new IdNotFoundException("Course with ID " + course.getCode());
        currentCourses.get(0).setTitle(course.getTitle());
        currentCourses.get(0).setDescription(course.getDescription());
        return course;
    }

    public void deleteCourse(int courseCode) throws IdNotFoundException {
        if (!courseList.removeIf(course -> course.getCode() == courseCode))
            throw new IdNotFoundException("Course with ID " + courseCode);
    }

}
