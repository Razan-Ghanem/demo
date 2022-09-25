package com.example.demo.controllar;

import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.controllar.mapper.ControllerMappers;
import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.InvoiceService;
import com.example.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequestMapping("/invoices")
@RestController
public class InvoiceControllar extends GeneralController {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public List<InvoiceDto> getInvoices() {
        List<Invoice> invoices= invoiceService.getInvoices();
        List<InvoiceDto> invoicesDtos = ControllerMappers.mapInvoices(invoices);
        return invoicesDtos;
        }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoice( @PathVariable("id") long invoiceId){
        ResponseEntity<Invoice> invoice = invoiceService.getInvoiceById(invoiceId);

        return new ResponseEntity(invoice,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<InvoiceDto> craeteInvoice(@RequestBody InvoiceDto invoiceDto) {

        Invoice newInvoice = ControllerMappers.mapInvoice(invoiceDto);
        InvoiceDto createdInvoiceDto = ControllerMappers.mapInvoiceDto(invoiceService.postInvoice(newInvoice));
        return new ResponseEntity<>(createdInvoiceDto, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public void updateInvoice(@PathVariable ("id") long invoiceId ,
                                                  @RequestBody InvoiceDto invoiceDto){
        Invoice invoice = ControllerMappers.mapInvoice(invoiceDto);
        InvoiceDto updatedInvoice = ControllerMappers.mapInvoiceDto(invoiceService.putInvoice(invoice,invoiceId));

    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable ("id") long invoiceId){

        invoiceService.deleteEntity(invoiceId);

    }
}
