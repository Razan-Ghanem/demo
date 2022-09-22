package com.example.demo.service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public class GeneralDemoService {
    @Autowired
    protected InvoiceRepository invoiceRepository;

// invoiceRepository   @Autowired
//    protected Attachment invoiceRepository;
//
//    @Autowired
//    protected InvoiceRepository invoiceRepository;
//
//    @Autowired
//    protected InvoiceRepository invoiceRepository;
//
//    @Autowired
//    protected InvoiceRepository invoiceRepository;

    protected List<Invoice> getInvoices(JpaSpecificationExecutor repository) {
        Specification distinctSpec = (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
        return repository.findAll(distinctSpec);
    }
}
