package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    void testInvoiceDaoSave() {

        Product tomato = new Product("Tomato");
        Product potato = new Product(("Potato"));
        Product cucumber = new Product("Cucumber");

        Item item1 = new Item(tomato, new BigDecimal(120), 10);
        Item item2 = new Item(potato, new BigDecimal(85), 100);
        Item item3 = new Item(cucumber, new BigDecimal(40), 80);
        Item item4 = new Item(tomato, new BigDecimal(200), 10);

        Invoice invoice = new Invoice("280822");

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);

        invoiceDao.save(invoice);

        int invoiceId = invoice.getId();
        long products = productDao.count();
        long items = itemDao.count();

        Optional<Invoice> invoiceExample = invoiceDao.findById(invoiceId);

        assertEquals(3, products);
        assertEquals(4, items);
        assertTrue(invoiceExample.isPresent());

        //cleanUp
        invoiceDao.deleteById(invoiceId);
    }
}
