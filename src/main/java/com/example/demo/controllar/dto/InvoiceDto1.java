package com.example.demo.controllar.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

@Data
public class InvoiceDto1 extends InvoiceDto{
    private Long id;
    private List<InvoiceItemDto> Items ;

}
