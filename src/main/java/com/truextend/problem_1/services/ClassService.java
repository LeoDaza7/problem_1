package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassService {

    private List<Class> classList = new ArrayList<>(
            Arrays.asList(
                    new Class(1,"Introductory Psycho biology","virtual class"),
                    new Class(2,"Art of Listening","virtual class"),
                    new Class(3,"Art History","virtual class"),
                    new Class(4,"Principles of computational geo-location analysis","virtual class")
            )
    );

    public Class createClass(Class classes) {
        classList.add(classes);
        return classes;
    }

    public List<Class> readClassAll() {
        return classList;
    }

    public Class readClass(int code) {
        return classList.stream().filter(classStream -> classStream.getCode() == code).collect(Collectors.toList()).get(0);
    }

    public Class updateClass(Class classes, int code) {
        classList.stream().filter(classStream -> classStream.getCode() == code).collect(Collectors.toList()).set(0,classes);
        return classes;
    }

    public void deleteClass(int code) {
        classList.removeIf(classStream -> classStream.getCode() == code);
    }

}
