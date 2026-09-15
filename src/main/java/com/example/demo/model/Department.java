package com.example.demo.model;

import com.example.demo.controller.StudentController;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.REMOVE
    )
    private List<Student> students = new ArrayList<>();

}
