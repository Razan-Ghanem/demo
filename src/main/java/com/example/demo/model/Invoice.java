package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "invoice")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Invoice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "inv_amount")
    private int inv_amount;
    @Column(name = "inv_date")
    private Date inv_date;
    @Column(name = "inv_num")
    private int inv_num;
    @Column(name = "inv_name")
    private String inv_name;


    @ManyToOne
    @JoinColumn(name= "employee_id",referencedColumnName = "id")
    private Employee employee;




    public Invoice(Long id, int inv_amount, Date inv_date, int inv_num, String inv_name, Employee employee) {
        this.id = id;
        this.inv_amount = inv_amount;
        this.inv_date = inv_date;
        this.inv_num = inv_num;
        this.inv_name = inv_name;
        this.employee = employee;
    }
}
