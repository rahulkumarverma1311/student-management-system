package com.deeRav.controller;

import com.deeRav.entites.Student;
import com.deeRav.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sms/")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("get")
    public ResponseEntity<List<Student>> fetchAll(){

      List<Student> list=this.studentService.getAll();
      if(list.size() <=0){
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }else{
          return new ResponseEntity<>(list,HttpStatus.OK);
      }
    }


    @GetMapping("byid/{id}")
    public ResponseEntity<Student>fetchById(@PathVariable("id") Integer id){
//        try {
//            Student student = this.studentService.getStudentById(id);
//            return new ResponseEntity<>(student,HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        Student student = this.studentService.getStudentById(id);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.ACCEPTED);

    }

    @PostMapping("add")
    public ResponseEntity<Student>addStudent(@RequestBody Student student){
        try {
            Student student1 = this.studentService.addStudent(student);
            return new ResponseEntity<>(student1,HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Student>deleteStudent(@PathVariable("id")Integer id){
        try {
            Student student = this.studentService.deleteUser(id);
            return new ResponseEntity<>(student,HttpStatus.ACCEPTED);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("put/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id")Integer id){
        try {
            Student student1 = this.studentService.upDateStudent(id,student);
            return new ResponseEntity<>(student1,HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
