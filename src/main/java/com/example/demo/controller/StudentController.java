package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController( StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/{deptId}")
    public ResponseEntity<String> createStudent(@RequestBody Student student, @PathVariable long deptId){
        studentService.createStudent(student, deptId);
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam String deptName ){
        studentService.createStudent(student, deptName);
        return ResponseEntity.ok("Done");
    }
}
