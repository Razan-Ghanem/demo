package com.example.demo.repository;

import com.example.demo.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long>, JpaSpecificationExecutor<InvoiceItem> {
    @Query("SELECT invoiceItem FROM InvoiceItem invoiceItem " +
            " WHERE invoiceItem.id = ?1 ")
    Optional<InvoiceItem> findInvoiceItemById(Long invoiceItemId);

//    @Query("SELECT invoiceItem FROM InvoiceItem invoiceItem " +
//            " WHERE invoiceItem.id = ?1 ")
//    Optional<InvoiceItem> saveInvoiceItemById(InvoiceItem invoiceItem,Long invoiceItemId);


}

