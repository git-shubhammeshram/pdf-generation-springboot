package com.pdfgenerator.service;

import java.io.ByteArrayInputStream;

import com.pdfgenerator.model.Invoice;

public interface InvoiceService {
    ByteArrayInputStream generateInvoicePdf(Long invoiceId);
    Invoice saveInvoice(Invoice invoice);
}