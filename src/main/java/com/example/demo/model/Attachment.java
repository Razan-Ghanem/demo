package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
@Table(name = "attachment")

public class Attachment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String attach_path;
    @Column
    private String attach_name;
    @Column
    private int attach_size;


    @ManyToOne
    @JoinColumn(name= "invoice_id",referencedColumnName = "id")
    private Invoice invoice;

}
