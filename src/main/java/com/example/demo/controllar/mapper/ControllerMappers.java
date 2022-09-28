package com.example.demo.controllar.mapper;

import com.example.demo.controllar.dto.*;
import com.example.demo.model.Employee;
import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceItem;
import com.example.demo.model.Item;
import com.example.demo.util.Mappers;

import java.util.ArrayList;
import java.util.List;

public class ControllerMappers {

    public static Invoice mapInvoice(InvoiceDto invoiceDto) {return Mappers.map(Invoice.class, invoiceDto);}
    public static InvoiceDto mapInvoiceDto(Invoice invoice) {
        return Mappers.map(InvoiceDto.class, invoice);
    }
    public static InvoiceDto1 mapInvoiceDto1(Invoice invoice) {return Mappers.map(InvoiceDto1.class, invoice);}
    public static List<InvoiceDto> mapInvoices(List<Invoice> invoices) {return Mappers.mapAsList(InvoiceDto.class, new ArrayList<>(invoices));}

    public static Item mapItem(ItemDto itemDto) {return Mappers.map(Item.class, itemDto);}
    public static ItemDto mapItemDto(Item item) {
        return Mappers.map(ItemDto.class, item);
    }
    public static List<ItemDto> mapItems(List<Item> items) {return Mappers.mapAsList(ItemDto.class, new ArrayList<>(items));}


    public static InvoiceItem mapInvoiceItem(InvoiceItemDto invoiceItemDto) {return Mappers.map(InvoiceItem.class, invoiceItemDto);}
    public static InvoiceItemDto mapInvoiceItemDto(InvoiceItem invoiceItem) {return Mappers.map(InvoiceItemDto.class, invoiceItem);}
    public static List<InvoiceItemDto> mapInvoiceItems(List<InvoiceItem> invoiceItems) {return Mappers.mapAsList(InvoiceItemDto.class, new ArrayList<>(invoiceItems));}

    public static Employee mapEmployee(EmployeeDto employeeDto) {return Mappers.map(Employee.class, employeeDto);}
    public static EmployeeDto mapEmployeeDto(Employee employee) {return Mappers.map(InvoiceItemDto.class, employee);}
    public static List<EmployeeDto> mapEmployees(List<Employee> employees) {return Mappers.mapAsList(EmployeeDto.class, new ArrayList<>(employees));}

}
