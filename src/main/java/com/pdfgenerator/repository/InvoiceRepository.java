package com.pdfgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pdfgenerator.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}