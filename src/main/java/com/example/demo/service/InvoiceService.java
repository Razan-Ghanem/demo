package com.example.demo.service;

import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.exception.ExceptionMessages;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.Employee;
import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceItemRepository;
import com.example.demo.repository.InvoiceRepository;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class InvoiceService extends GeneralDemoService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    public List<Invoice> getInvoices() {
        Specification distinctSpec = (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
        return invoiceRepository.findAll(distinctSpec);
    }

    // Todo: Add some code
    public Invoice getInvoiceById(long invoiceId) {

        Optional<Invoice> optionalInvoice = invoiceRepository.findInvoiceById(invoiceId);

        if (!(optionalInvoice.isPresent())){
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);
        }

        return optionalInvoice.get();
    }

    public Invoice postInvoice(Invoice newInvoice) {

        //newInvoice.getItems().stream().forEach(invoiceItem -> invoiceItem.setInvoice(newInvoice));
        return invoiceRepository.save(newInvoice);
    }

    //TODO: check how to do exception handling accross the code
    //TODO: PUT VS POST, What is idempotency ?
    public Invoice putInvoice(Invoice invoice, long invoiceId){
        // Find by id, throw exception 404
        Optional<Invoice> invoiceupdated = invoiceRepository.findInvoiceById(invoiceId);
        if (!(invoiceupdated.isPresent())){
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);
        }

        invoiceupdated.get().setInv_amount(invoice.getInv_amount());
        invoiceupdated.get().setInv_num(invoice.getInv_num());
        invoiceupdated.get().setInv_name(invoice.getInv_name());
        invoiceupdated.get().setInv_date(invoice.getInv_date());
        return invoiceRepository.save(invoiceupdated.get());

    }

    public void deleteEntity(Long invoiceId) {
        Optional<Invoice> invoiceEntity = invoiceRepository.findInvoiceById(invoiceId);

        // Todo: Return 404
        if (!(invoiceEntity.isPresent())) {
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND) ;
        }
        invoiceRepository.delete(invoiceEntity.get());

    }


}
