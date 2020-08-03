package com.truextend.problem_1.repositories;

import com.truextend.problem_1.DAOs.AssignmentCourseStudentDAO;
import com.truextend.problem_1.DAOs.CourseDAO;
import com.truextend.problem_1.DAOs.StudentDAO;
import com.truextend.problem_1.entities.AssignmentCourseStudent;
import com.truextend.problem_1.entities.Course;
import com.truextend.problem_1.entities.Student;
import com.truextend.problem_1.errors.AssignmentRepeatedException;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MockData implements CourseDAO, StudentDAO, AssignmentCourseStudentDAO {

    private static List<Course> courseList = new ArrayList<>(
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
        courseList.add(newCourse);
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

    public Course updateCourse(Course course, int courseCode) throws IdNotFoundException  {
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

    private static List<Student> studentList = new ArrayList<>(
            Arrays.asList(
                    new Student(0,"Wilson","John"),
                    new Student(1,"Graham","Jane"),
                    new Student(2,"Bam","Pam")
            )
    );

    public Student createStudent(Student student) throws IdRepeatedException {
        if (studentList.stream().noneMatch(studentStream -> studentStream.getStudentID() == student.getStudentID())){
            studentList.add(student);
            return student;
        } else {
            throw new IdRepeatedException("Student with ID " + student.getStudentID());
        }

    }

    public List<Student> readStudentAll(){
        return studentList;
    }

    public Student readStudent(int studentId) throws IdNotFoundException {
        List<Student> currentStudent = studentList.stream().filter(student -> student.getStudentID() == studentId).collect(Collectors.toList());
        if (!currentStudent.isEmpty()) {
            return currentStudent.get(0);
        } else {
            throw new IdNotFoundException("Student with ID " + studentId);
        }
    }

    public Student updateStudent(Student student, int studentId) throws IdNotFoundException {
        List<Student> currentStudent = studentList.stream().filter(studentStream -> studentStream.getStudentID() == studentId).collect(Collectors.toList());
        if (!currentStudent.isEmpty()) {
            currentStudent.get(0).setFirstName(student.getFirstName());
            currentStudent.get(0).setLastName(student.getLastName());
            return student;
        } else {
            throw new IdNotFoundException("Student with ID " + student.getStudentID());
        }

    }

    public void deleteStudent(int studentId) throws IdNotFoundException {
        if(!studentList.removeIf(student -> student.getStudentID() == studentId))
            throw new IdNotFoundException("Student with ID " + studentId);
    }

    private static List<AssignmentCourseStudent> classStudentAssignmentList = new ArrayList<>(
            Arrays.asList(
                    new AssignmentCourseStudent(0, studentList.get(0), courseList.get(1)),
                    new AssignmentCourseStudent(1, studentList.get(0), courseList.get(2)),
                    new AssignmentCourseStudent(2, studentList.get(1), courseList.get(1)),
                    new AssignmentCourseStudent(3, studentList.get(1), courseList.get(3))
            )
    );

    public List<AssignmentCourseStudent> readAllCourseStudentAssignments() {
        return classStudentAssignmentList;
    }

    public AssignmentCourseStudent createAssignmentCourseStudent(AssignmentCourseStudent newAssignment) throws IdRepeatedException, AssignmentRepeatedException, IdNotFoundException {
        if(classStudentAssignmentList.stream().anyMatch(assignmentOnList -> assignmentOnList.getAssignmentId() == newAssignment.getAssignmentId()))
            throw new IdRepeatedException("Assignment with ID " + newAssignment.getAssignmentId());
        if(classStudentAssignmentList.stream().anyMatch(assignmentOnList -> assignmentOnList.getCourse().getCode() == newAssignment.getCourse().getCode() &&
                assignmentOnList.getStudent().getStudentID() == newAssignment.getStudent().getStudentID()))
            throw new AssignmentRepeatedException("Student with ID " + newAssignment.getStudent().getStudentID() + " and course with code " + newAssignment.getCourse().getCode());
        if (studentList.stream().noneMatch(student -> student.getStudentID() == newAssignment.getStudent().getStudentID()))
            throw new IdNotFoundException("Student with ID " +  newAssignment.getStudent().getStudentID());
        if (courseList.stream().noneMatch(course -> course.getCode() == newAssignment.getCourse().getCode()))
            throw new IdNotFoundException("Course with ID " +  newAssignment.getCourse().getCode());
        classStudentAssignmentList.add(newAssignment);
        return newAssignment;
    }

    public List<AssignmentCourseStudent> readCourseAssignments(int code) throws IdNotFoundException {
        List<AssignmentCourseStudent> courseAssignments = classStudentAssignmentList.stream()
                .filter(courseStudentAssignment -> courseStudentAssignment.getCourse().getCode() == code)
                .collect(Collectors.toList());
        if (!courseAssignments.isEmpty()){
            return courseAssignments;
        } else {
            throw new IdNotFoundException("Course with ID " + code);
        }
    }

    public List<AssignmentCourseStudent> readStudentsAssignments(int studentId) throws IdNotFoundException {
        List<AssignmentCourseStudent> studentAssignments = classStudentAssignmentList.stream()
                .filter(courseStudentAssignment -> courseStudentAssignment.getStudent().getStudentID() == studentId)
                .collect(Collectors.toList());
        if(!studentAssignments.isEmpty()){
            return studentAssignments;
        } else {
            throw new IdNotFoundException("Student with ID " + studentId);
        }
    }

}
