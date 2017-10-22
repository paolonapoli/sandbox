/*
 * File InvoiceRepositoryTest.java of project sandbox-s5-dal.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.test.dal.mysql.invoice;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import it.pn.sandbox.spring5.dal.conf.SandboxMysqlConfig;
import it.pn.sandbox.spring5.dal.mysql.invoice.InvoiceRepository;
import it.pn.sandbox.spring5.model.mysql.invoice.Invoice;

/**
 * Class InvoiceRepositoryTest.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SandboxMysqlConfig.class })
@Transactional
// @Commit // does the COMMIT at the end
public class InvoiceRepositoryTest {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private EntityManager em;

    // @Before
    public void init() {
	this.invoiceRepository.deleteAll();
	this.em.flush();
    }

    @Test
    public void pupulateInvoice() {
	init();

	System.out.println("************ Adding Inovices ********************");
	// first
	Invoice invoice = new Invoice();
	invoice.setNote("This is a note");
	invoice.setUserId(1234L);
	invoice.setOrderId(1234L);
	this.invoiceRepository.save(invoice);

	invoice = new Invoice();
	invoice.setNote("This is a note #2");
	invoice.setUserId(21234L);
	invoice.setOrderId(21234L);
	this.invoiceRepository.save(invoice);

	Iterable<Invoice> all = this.invoiceRepository.findAll();
	for (Invoice inv : all) {
	    String string = ToStringBuilder.reflectionToString(inv, ToStringStyle.MULTI_LINE_STYLE);
	    System.out.println(string);
	}
    }

    @Test
    public void pupulateInvoiceException() {
	System.out.println("************ Adding Inovices ********************");
	// first
	Invoice invoice = new Invoice();
	invoice.setNote("This is a note");
	invoice.setUserId(1234L);
	invoice.setOrderId(1234L);
	this.invoiceRepository.save(invoice);

	throw new RuntimeException("volontary to test rollback");
    }
}
