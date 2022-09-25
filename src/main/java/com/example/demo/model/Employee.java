package com.example.demo.model;
import com.example.demo.model.enums.EmployeeRole;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employee")
@Getter
@Setter
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="emp_role")
    @Enumerated(EnumType.STRING)
    private EmployeeRole emp_role;
    @Column(name="emp_address")
    private String emp_address;
    @Column(name="emp_pass")
    private String emp_pass;
    @Column(name="emp_number")
    private String emp_number;

    @Column(name="emp_firstname")
    private String emp_firstName;

    @Column(name="emp_lastname")
    private String emp_lastName;
}
