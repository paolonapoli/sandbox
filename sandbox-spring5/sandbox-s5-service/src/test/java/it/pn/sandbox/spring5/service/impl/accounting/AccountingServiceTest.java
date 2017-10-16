/*
 * File AccountingServiceTest.java of project sandbox-s5-service.
 * File created on 16 ott 2017 at 23:22:31 at PN-HQ.
 */
package it.pn.sandbox.spring5.service.impl.accounting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import it.pn.sandbox.spring5.service.accounting.AccountingService;
import it.pn.sandbox.spring5.service.accounting.exception.AlreadyExistentGroupException;
import it.pn.sandbox.spring5.service.conf.SandboxServiceConfig;

/**
 * Class AccountingServiceTest representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SandboxServiceConfig.class })
@Transactional
// @Commit
public class AccountingServiceTest {

    @Autowired
    private AccountingService accountingService;

    @Test
    public void createGroup() throws Exception {
	this.accountingService.createGroup("pezzi", "pezzi");
    }

    @Test(expected = AlreadyExistentGroupException.class)
    public void createExistentGroup() throws Exception {
	this.accountingService.createGroup("user", "user");
    }
}
