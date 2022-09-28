package com.example.demo.controllar;
import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.controllar.dto.InvoiceDto1;
import com.example.demo.controllar.mapper.ControllerMappers;
import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
    public ResponseEntity<InvoiceDto1> getInvoice( @PathVariable("id") long invoiceId){

        InvoiceDto1 invoiceDto1 = ControllerMappers.mapInvoiceDto1(invoiceService.getInvoiceById(invoiceId));
        return new ResponseEntity(invoiceDto1,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<InvoiceDto1> craeteInvoice(@RequestBody InvoiceDto1 invoiceDto1) {

        Invoice newInvoice = ControllerMappers.mapInvoice(invoiceDto1);
        InvoiceDto1 createdInvoiceDto1 = ControllerMappers.mapInvoiceDto1(invoiceService.postInvoice(newInvoice));
        return new ResponseEntity<>(createdInvoiceDto1, HttpStatus.CREATED);
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
