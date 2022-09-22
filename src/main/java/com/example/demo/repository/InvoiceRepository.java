package com.example.demo.repository;

import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice,Long>, JpaSpecificationExecutor<Invoice> {

    @Query("SELECT be FROM Invoice be " +
            " WHERE be.id = ?1 ")
    Optional<Invoice> findInvoiceById(Long invoiceId);


}
