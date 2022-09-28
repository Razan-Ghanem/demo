package com.example.demo.controllar;


import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.controllar.dto.InvoiceItemDto;
import com.example.demo.controllar.mapper.ControllerMappers;
import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceItem;
import com.example.demo.service.InvoiceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/invoiceItems")
@RestController
public class InvoiceItemControllar extends GeneralController {
    @Autowired
    InvoiceItemService invoiceItemService;

    @GetMapping
    public List<InvoiceItemDto> getInvoiceItems(){
        List<InvoiceItem> invoiceItems  = invoiceItemService.getInvoiceItems();
        List<InvoiceItemDto> invoiceItemDtos = ControllerMappers.mapInvoiceItems(invoiceItems);
        return invoiceItemDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItem> getInvoiceById(@PathVariable("id") long invoiceItemId){
        ResponseEntity<InvoiceItem> invoiceItem = invoiceItemService.getInvoiceItemById(invoiceItemId);

        return new ResponseEntity(invoiceItem, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<InvoiceItemDto> craeteInvoiceItem(@RequestBody InvoiceItemDto invoiceItemDto) {
        InvoiceItem newInvoiceItem = ControllerMappers.mapInvoiceItem(invoiceItemDto);
        InvoiceItemDto createdInvoiceItemDto = ControllerMappers.mapInvoiceItemDto(invoiceItemService.postInvoiceItem(newInvoiceItem));
        return new ResponseEntity(createdInvoiceItemDto, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public void updateInvoiceItem(@PathVariable ("id") long invoiceItemId ,
                              @RequestBody InvoiceItemDto invoiceItemDto){
        InvoiceItem invoiceItem = ControllerMappers.mapInvoiceItem(invoiceItemDto);
        InvoiceItemDto updatedInvoiceItem = ControllerMappers.mapInvoiceItemDto(invoiceItemService.putInvoiceItem(invoiceItem,invoiceItemId));
    }

    @DeleteMapping("/{id}")
    public void deleteInvoiceItem(@PathVariable ("id") long invoiceItemId){
        invoiceItemService.deleteEntity(invoiceItemId);

    }





}
