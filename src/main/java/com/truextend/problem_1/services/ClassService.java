package com.truextend.problem_1.services;

import com.truextend.problem_1.entities.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassService {

    private List<Class> classList = new ArrayList<>(
            Arrays.asList(
                    new Class(1,"Introductory Psycho biology","virtual class"),
                    new Class(2,"Art of Listening","virtual class"),
                    new Class(3,"Art History","virtual class"),
                    new Class(4,"Principles of computational geo-location analysis","virtual class")
            )
    );

}
