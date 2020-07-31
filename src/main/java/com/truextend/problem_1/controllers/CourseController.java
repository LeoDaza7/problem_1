package com.truextend.problem_1.controllers;

import com.truextend.problem_1.entities.Course;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import com.truextend.problem_1.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<Course> getCourseList() {
        return courseService.readCourseAll();
    }

    @GetMapping("/{id}")
    public Course getCourses(@PathVariable(value = "id") int code) throws IdNotFoundException {
        return courseService.readCourse(code);
    }

    @PostMapping("")
    public Course postCourse(@RequestBody Course course) throws IdRepeatedException {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course putCourse(@RequestBody Course course, @PathVariable(value = "id") int code) throws IdNotFoundException {
        return courseService.updateCourse(course,code);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable(value = "id") int code) throws IdNotFoundException {
        courseService.deleteCourse(code);
    }

}
