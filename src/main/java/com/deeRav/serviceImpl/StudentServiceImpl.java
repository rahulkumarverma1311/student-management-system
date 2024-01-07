package com.deeRav.serviceImpl;

import com.deeRav.entites.Student;
import com.deeRav.repo.StudentRepo;
import com.deeRav.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Override
    public List<Student> getAll() {
        List<Student> li = this.studentRepo.findAll();
        return li;
    }

    @Override
    public Student addStudent(Student student) {
        Student st = this.studentRepo.save(student);
        return st;
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Student student = this.studentRepo.findByStudentId(studentId);
        return student;
    }

    @Override
    public Student upDateStudent(Integer studentId, Student student) {
        Student student1 = this.studentRepo.findByStudentId(studentId);
        student1.setStudentName(student.getStudentName());
        student1.setRollNo(student.getRollNo());
        student1.setClassName(student.getClassName());
        Student update = this.studentRepo.save(student1);
        return update;
    }

    @Override
    public Student deleteUser(Integer studentId) {
        Student student = this.studentRepo.findByStudentId(studentId);
        this.studentRepo.delete(student);
        return student;
    }
}
