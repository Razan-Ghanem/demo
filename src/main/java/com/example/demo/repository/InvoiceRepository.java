package com.example.demo.repository;

import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface InvoiceRepository extends JpaRepository<Invoice,Long>, JpaSpecificationExecutor<Invoice> {

    @Query("SELECT invoice FROM Invoice invoice"+
            " LEFT JOIN FETCH invoice.Items where invoice.id = ?1" )
    Optional<Invoice> findInvoiceById(Long invoiceId);

}

