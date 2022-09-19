package com.example.demo.model;

import com.example.demo.model.enums.EmployeeRole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")

public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Enumerated(EnumType.STRING)
    private EmployeeRole emp_role;
    @Column
    private String emp_address;
    @Column
    private String emp_pass;
    @Column
    private String emp_number;
    @Column
    private String emp_firstName;
    @Column
    private String emp_lastName;
}
