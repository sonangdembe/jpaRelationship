package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Student;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    DepartmentRepository departmentRepository;
    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student, long id){
        Department department = departmentRepository.getDepartmentById(id);
        student.setDepartment(department);
        studentRepository.createStudent(student);
    }


    @Transactional
    public void createStudent(Student student, String deptName){
        Department department = new Department();
        department.setName(deptName);
        departmentRepository.createStudent(department);
        student.setDepartment(department);
        studentRepository.createStudent(student);
    }
}
