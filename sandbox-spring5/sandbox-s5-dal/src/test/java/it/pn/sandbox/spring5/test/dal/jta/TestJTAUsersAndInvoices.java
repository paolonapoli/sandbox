/*
 * File TestJTAUsersAndInvoices.java of project sandbox-s5-dal.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.test.dal.jta;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import it.pn.sandbox.spring5.dal.conf.jta.SandboxJTADalConfig;
import it.pn.sandbox.spring5.dal.mysql.invoice.InvoiceRepository;
import it.pn.sandbox.spring5.dal.sql.accounting.UserRespository;
import it.pn.sandbox.spring5.model.mysql.invoice.Invoice;
import it.pn.sandbox.spring5.model.sql.accounting.User;

/**
 * Class TestJTAUsersAndInvoices.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SandboxJTADalConfig.class })
public class TestJTAUsersAndInvoices {
    @Autowired
    private UserRespository userRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    @Transactional
    @Commit // does the COMMIT at the end
    public void pupulateUsersAndInvoice() {
	User user = insertUser();

	Invoice invoice = insertInvoice();

	// find created user
	this.userRepository.findById(user.getId());
	String string = ToStringBuilder.reflectionToString(user, ToStringStyle.MULTI_LINE_STYLE);
	System.out.println(string);

	// find created invoice
	this.invoiceRepository.findById(invoice.getId());
	string = ToStringBuilder.reflectionToString(invoice, ToStringStyle.MULTI_LINE_STYLE);
	System.out.println(string);

	// delete created user
	this.userRepository.delete(user);

	// delete created invoice
	this.invoiceRepository.delete(invoice);

	Assert.assertTrue("At least one user", this.userRepository.count() == 0);
	Assert.assertTrue("At least one invoice", this.invoiceRepository.count() == 0);
    }

    @Test
    @Transactional(rollbackFor = RuntimeException.class)
    // @Commit // does the COMMIT at the end
    public void pupulateUsersAndInvoiceException() {
	insertUser();

	insertInvoice();

	throw new RuntimeException("Volontary exception to test rollback (works on Primary TX manager)");
    }

    @Test
    @Transactional
    @Commit // does the COMMIT at the end
    public void pupulateUsersAndInvoiceSuccess() {
	insertUser();

	insertInvoice();
	// throw new RuntimeException("Volontary exception to test rollback (works on Primary TX manager)");
    }

    /*
     * PRIVATES
     */
    private User insertUser() {
	System.out.println("************ Adding User myuser ********************");
	// save user

	User u = new User();
	u.setUsername("myuser");
	u.setPassword("mypassword");
	u.setEmail("myemail@test.com");
	u.setTelephone("1234567890");
	return this.userRepository.save(u);
    }

    private Invoice insertInvoice() {
	System.out.println("************ Adding Invoice ord #1234 ********************");
	Invoice invoice = new Invoice();
	invoice.setNote("This is a note");
	invoice.setUserId(1234L);
	invoice.setOrderId(1234L);
	return this.invoiceRepository.save(invoice);
    }

}
