package com.example.demo.service;

import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceItem;
import com.example.demo.repository.InvoiceItemRepository;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public class GeneralDemoService {
    @Autowired
    protected InvoiceRepository invoiceRepository;


   @Autowired
    protected InvoiceItemRepository invoiceItemRepository;

    @Autowired
    protected ItemRepository itemRepository;
//
//    @Autowired
//    protected InvoiceRepository invoiceRepository;
//
//    @Autowired
//    protected InvoiceRepository invoiceRepository;


}
