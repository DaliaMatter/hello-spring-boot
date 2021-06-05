package com.testProject.demo.Controller;
import java.util.*;

import com.testProject.demo.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
public class hello {

    public List<Student> studentsList = new ArrayList<Student>();

    @RequestMapping(value="/hello")
    public String sayHello() {
        return "hello world";
    }

    @GetMapping("/hello/students")
    public List<Student> getStudent() {
        return studentsList;
    }

    @PostMapping("/hello/addStudent")
    public Student addStudent(@RequestBody Student student) {
        studentsList.add(student);
        return student;
    }

    @DeleteMapping("/hello/deleteStudent/{id}")
    //List<Student>
    public List<Student> deleteStudent(@PathVariable long id) {

        for (Student student: studentsList) {
            if(student.getId() == id) {
                int index = studentsList.indexOf(student);
                studentsList.remove(index);
                //return student;
                break;
            }
        }
        return studentsList;
    }
    @PutMapping("/hello/updateStudent/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student new_student) {
        for (Student student: studentsList) {
            if(student.getId() == id ) {
                int index = studentsList.indexOf(student);
                studentsList.remove(index);
                //return student;
                studentsList.add(new_student);
                break;
            }
        }
        return new_student;
    }
}
