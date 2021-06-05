package com.testProject.demo.Controller;

import com.testProject.demo.model.Student;
import com.testProject.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService stdService;

    @GetMapping("/students")
    @ResponseBody
    public List<Student> getStudents() {
        return stdService.getStudents();
    }

    @PostMapping("/sStudent")
    @ResponseBody
    public void save(@RequestBody Student std) {
        stdService.saveStudent(std);
    }

    @DeleteMapping("/deleteStudent/{id}")
    @ResponseBody
    public void delete(@PathVariable long id) {
        Student std = stdService.getStudent(id);
        stdService.deleteStudent(std);
    }
}
