package com.example.demo.controllar.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class InvoiceDto {
    private Long id;

    private int inv_amount;

    private Date inv_date;

    private int inv_num;

    private String inv_name;









}
