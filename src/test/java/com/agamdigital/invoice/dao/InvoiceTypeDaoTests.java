package com.agamdigital.invoice.dao;

import com.agamdigital.invoice.entity.InvoiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {
        "/sql/delete-invoice-type.sql",
        "/sql/insert-inactive-invoice-type.sql"
})
public class InvoiceTypeDaoTests {

    @Autowired
    InvoiceTypeDao invoiceTypeDao;

    @Test
    public void testInsertInvoiceType() throws InterruptedException {
        InvoiceType it = new InvoiceType();
        it.setCode("IT-001");
        it.setName("Invoice Type Test");

        Assertions.assertNull(it.getId());
        invoiceTypeDao.save(it);
        Assertions.assertNotNull(it.getId());
        Assertions.assertNotNull(it.getCreated());
        Assertions.assertNotNull(it.getUpdated());
        Assertions.assertNotNull(it.getCreatedBy());
        Assertions.assertNotNull(it.getUpdatedBy());
        Assertions.assertNotNull(it.getStatusRecord());
        System.out.println("ID: " + it.getId());
        System.out.println("Created Time: " + it.getCreated());
        System.out.println("Updated Time: " + it.getUpdated());
        System.out.println("Created By: " + it.getCreatedBy());
        System.out.println("Updated By: " + it.getUpdatedBy());
        System.out.println("Status Record: " + it.getStatusRecord());

        Assertions.assertEquals(it.getCreated(), it.getUpdated());

        Thread.sleep(1000);
        it.setName("Test update");
        it = invoiceTypeDao.save(it);
        System.out.println("Created Time: " + it.getCreated());
        System.out.println("Updated Time: " + it.getUpdated());
        Assertions.assertNotEquals(it.getCreated(), it.getUpdated());
    }

    @Test
    public void testQuerySoftDelete() {
        Long recordCount = invoiceTypeDao.count();
        System.out.println("jumlah record: " + recordCount);
        Assertions.assertEquals(1, recordCount);
    }

    @Test
    public void testSoftDelete() {
        InvoiceType it = invoiceTypeDao.findById("test0002").get();
        invoiceTypeDao.delete(it);

        Long records = invoiceTypeDao.count();
        System.out.println("Records: " + records);
        Assertions.assertEquals(0, records);
    }
}
