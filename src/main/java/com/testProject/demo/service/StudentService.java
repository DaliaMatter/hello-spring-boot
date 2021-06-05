package com.testProject.demo.service;

import com.testProject.demo.model.Student;
import com.testProject.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepo.delete(student);
    }

    public Student getStudent(long id) {
        Optional<Student> optStudent = studentRepo.findById(id);

        Student std = null;
        if(optStudent.isPresent()) {
            std = optStudent.get();
        }
        return std;
    }
}
