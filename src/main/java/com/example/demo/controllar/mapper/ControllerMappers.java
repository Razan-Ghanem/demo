package com.example.demo.controllar.mapper;

import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.model.Invoice;
import com.example.demo.util.Mappers;

import java.util.ArrayList;
import java.util.List;

public class ControllerMappers {

    public static Invoice mapInvoice(InvoiceDto invoiceDto) {
        return Mappers.map(Invoice.class, invoiceDto);
    }
    public static InvoiceDto mapInvoiceDto(Invoice invoice) {
        return Mappers.map(InvoiceDto.class, invoice);
    }
    public static List<InvoiceDto> mapInvoices(List<Invoice> invoices) {
        return Mappers.mapAsList(InvoiceDto.class, new ArrayList<>(invoices));
    }
}
