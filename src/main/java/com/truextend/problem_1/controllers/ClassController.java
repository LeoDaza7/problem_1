package com.truextend.problem_1.controllers;

import com.truextend.problem_1.entities.Class;
import com.truextend.problem_1.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/class")
    public List<Class> getClassList() {
        return classService.readClassAll();
    }

    @GetMapping("/class/{id}")
    public Class getClass(@PathVariable(value = "id") int code){
        return classService.readClass(code);
    }

    @PostMapping("/class")
    public Class postClass(@RequestBody Class classes) {
        return classService.createClass(classes);
    }

    @PutMapping("/class/{id}")
    public Class putClass(@RequestBody Class classes, @PathVariable(value = "id") int code) {
        return classService.updateClass(classes,code);
    }

    @DeleteMapping("/class/{id}")
    public void deleteClass(@PathVariable(value = "id") int code) {
        classService.deleteClass(code);
    }

}
