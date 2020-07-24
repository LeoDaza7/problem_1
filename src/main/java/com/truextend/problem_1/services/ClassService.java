package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.Class;
import com.truextend.problem_1.errors.IdNotFoundException;
import com.truextend.problem_1.errors.IdRepeatedException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassService {

    private List<Class> classList = new ArrayList<>(
            Arrays.asList(
                    new Class(1,"Introductory Psycho biology","virtual class"),
                    new Class(2,"Art of Listening","virtual class"),
                    new Class(3,"Art History","virtual class"),
                    new Class(4,"Principles of computational geo-location analysis","virtual class")
            )
    );

    public Class createClass(Class classes) throws IdRepeatedException {
        if (classList.stream().noneMatch(studentStream -> studentStream.getCode() == classes.getCode())){
            classList.add(classes);
            return classes;
        } else {
            throw new IdRepeatedException("Class with ID " + classes.getCode());
        }

    }

    public List<Class> readClassAll() {
        return classList;
    }

    public Class readClass(int code) throws IdNotFoundException {
        List<Class> currentClass = classList.stream().filter(classStream -> classStream.getCode() == code).collect(Collectors.toList());
        if (!currentClass.isEmpty()) {
            return currentClass.get(0);
        } else {
            throw new IdNotFoundException("Class with ID " + code);
        }
    }

    public Class updateClass(Class classes, int code ) throws IdNotFoundException  {
        List<Class> currentClass = classList.stream().filter(classStream -> classStream.getCode() == code).collect(Collectors.toList());
        if (!currentClass.isEmpty()){
            currentClass.get(0).setTitle(classes.getTitle());
            currentClass.get(0).setDescription(classes.getDescription());
            return classes;
        } else {
            throw new IdNotFoundException("Class with ID " + classes.getCode());
        }

    }

    public void deleteClass(int code) throws IdNotFoundException {
        if (!classList.removeIf(classStream -> classStream.getCode() == code))
            throw new IdNotFoundException("Class with ID " + code);
    }

}
