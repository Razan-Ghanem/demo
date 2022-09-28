package com.example.demo.model;

import com.example.demo.controllar.dto.InvoiceItemDto;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor

public class Invoice {
    @Id
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


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> Items = new ArrayList<>();


    public Invoice(Long id, int inv_amount, Date inv_date, int inv_num, String inv_name, Employee employee) {
        this.id = id;
        this.inv_amount = inv_amount;
        this.inv_date = inv_date;
        this.inv_num = inv_num;
        this.inv_name = inv_name;
        this.employee = employee;
    }
}
