package com.example.demo.controllar.dto;

import com.example.demo.model.enums.EmployeeRole;

import javax.persistence.Column;

public class EmployeeDto {

    private Long id;

    private EmployeeRole emp_role;
    private String emp_address;
    private String emp_pass;
    private String emp_number;
    private String emp_firstName;
    private String emp_lastName;
}
