package com.example.demo.service;

import com.example.demo.exception.ExceptionMessages;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceItem;
import com.example.demo.repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceItemService extends GeneralDemoService{
    @Autowired
    InvoiceItemRepository invoiceItemRepository;

    public List<InvoiceItem> getInvoiceItems(){
        Specification distinctSpec = (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
        return invoiceItemRepository.findAll(distinctSpec);
    }

    // Todo: Add some code
    public ResponseEntity<InvoiceItem> getInvoiceItemById(long invoiceItemId) {
    try {

    Optional<InvoiceItem> optionalInvoiceItem = invoiceItemRepository.findInvoiceItemById(invoiceItemId);
    return new ResponseEntity(optionalInvoiceItem, HttpStatus.OK);
        }catch (Exception e){
    throw new ResourceNotFoundException(e.getMessage());
}

//        if (!(optionalInvoiceItem.isPresent())){
//            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);
//        }
//        return new ResponseEntity(optionalInvoiceItem, HttpStatus.OK);
    }

    public InvoiceItem postInvoiceItem(InvoiceItem newInvoiceItem) {

        return invoiceItemRepository.save(newInvoiceItem);
    }

//    public InvoiceItem  postInvoiceItemById(InvoiceItem newInvoiceItem, long invoiceId ){
//        Optional<Invoice>  invoice= invoiceRepository.findInvoiceById(invoiceId);
//        if (!(invoice.isPresent())){
//            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);
//        }
//        return invoiceItemRepository.saveInvoiceItemById(newInvoiceItem,invoiceId );
//    }

    //TODO: check how to do exception handling accross the code
    //TODO: PUT VS POST, What is idempotency ?
    public InvoiceItem putInvoiceItem(InvoiceItem invoiceItem, long invoiceItemId){
        // Find by id, throw exception 404
        Optional<InvoiceItem> invoiceItemupdated = invoiceItemRepository.findInvoiceItemById(invoiceItemId);
        if (!(invoiceItemupdated.isPresent())){
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);
        }

        invoiceItemupdated.get().setQuantity(invoiceItem.getQuantity());
        invoiceItemupdated.get().setUnit_price(invoiceItem.getUnit_price());
        return invoiceItemRepository.save(invoiceItemupdated.get());

    }

    public void deleteEntity(Long invoiceItemId) {
        Optional<InvoiceItem> invoiceItemEntity = invoiceItemRepository.findInvoiceItemById(invoiceItemId);

        // Todo: Return 404
        if (!(invoiceItemEntity.isPresent())) {
            throw new ResourceNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND) ;
        }
        invoiceItemRepository.delete(invoiceItemEntity.get());

    }



}
