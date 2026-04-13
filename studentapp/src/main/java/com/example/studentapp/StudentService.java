package com.example.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public Student getStudentById(String id){
        return repo.findById(id).orElse(null);
    }

    public Student updateStudent(String id , Student student){
        student.setId(id);
        return repo.save(student);
    }

    public void deleteStudent(String id){
        repo.deleteById(id);
    }

    @Autowired
    private StudentRepository repo;

    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }
}