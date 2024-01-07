package com.deeRav.service;

import com.deeRav.entites.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();
    Student addStudent(Student student);
    Student getStudentById(Integer studentId);
    Student upDateStudent(Integer studentId,Student student);
    Student deleteUser(Integer studentId);
}
