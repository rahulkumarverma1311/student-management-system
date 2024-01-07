package com.deeRav.repo;

import com.deeRav.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

    Student findByStudentId(Integer id);
}
