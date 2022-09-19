package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "invoice")

public class Invoice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private double inv_amount;
    @Column
    private Date inv_date;
    @Column
    private int inv_num;
    @Column
    private String inv_name;
    @Column
    private int customer_id;
    @Column
    private int employee_id;

    @ManyToOne
    @JoinColumn(name= "employee_id",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name= "customer_id",referencedColumnName = "id")
    private Customer customer;

}
