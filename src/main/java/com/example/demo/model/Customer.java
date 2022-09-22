package com.example.demo.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")

public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cust_phone;
    @Column
    private String cust_address;
    @Column
    private String cust_name;


}
