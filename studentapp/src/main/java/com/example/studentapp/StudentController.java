package com.example.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;



    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new RuntimeException("Name cannot be empty");
        }
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id){
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id , @RequestBody Student student){
        return service.updateStudent(id , student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id){
        service.deleteStudent(id);
        return "Student deleted successfully";
    }


    }
