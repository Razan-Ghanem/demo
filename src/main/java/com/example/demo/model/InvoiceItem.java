package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "invoice_item")

public class InvoiceItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private double unitPrice;
    @Column
    private int quantity;


    @ManyToOne
    @JoinColumn(name= "invoice_id",referencedColumnName = "id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name= "item_id",referencedColumnName = "id")
    private Item item;
}
