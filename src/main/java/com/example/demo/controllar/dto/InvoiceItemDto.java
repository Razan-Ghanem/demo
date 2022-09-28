package com.example.demo.controllar.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InvoiceItemDto {
    private Long id;
    private int quantity;
    private Double unit_price;
    private ItemDto item ;

}
