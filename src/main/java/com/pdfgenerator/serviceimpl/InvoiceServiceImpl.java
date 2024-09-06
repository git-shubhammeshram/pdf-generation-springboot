package com.pdfgenerator.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pdfgenerator.model.Invoice;
import com.pdfgenerator.model.InvoiceItem;
import com.pdfgenerator.repository.InvoiceRepository;
import com.pdfgenerator.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public ByteArrayInputStream generateInvoicePdf(Long invoiceId) {
    	
    	
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow();

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("Invoice: " + invoice.getInvoiceNumber()));
            document.add(new Paragraph("Customer: " + invoice.getCustomerName()));
            document.add(new Paragraph("Email: " + invoice.getCustomerEmail()));
            document.add(new Paragraph("Business: " + invoice.getBusinessDetails().getBusinessName()));
            document.add(new Paragraph("Address: " + invoice.getBusinessDetails().getAddress()));
            document.add(new Paragraph("Contact: " + invoice.getBusinessDetails().getContactNumber()));

            PdfPTable table = new PdfPTable(3);
            table.addCell("Item Name");
            table.addCell("Quantity");
            table.addCell("Price");

            for (InvoiceItem item : invoice.getItems()) {
                table.addCell(item.getItemName());
                table.addCell(String.valueOf(item.getQuantity()));
                table.addCell(String.valueOf(item.getPrice()));
            }

            document.add(table);
            document.close();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
