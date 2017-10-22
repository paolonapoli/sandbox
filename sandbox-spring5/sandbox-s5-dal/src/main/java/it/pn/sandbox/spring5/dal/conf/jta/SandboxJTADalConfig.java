/*
 * File SandboxJTADalConfig.java of project sandbox-s5-dal.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.conf.jta;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

/**
 * Class SandboxJTADalConfig.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@ComponentScan
@EnableTransactionManagement
@Import({ SandboxJTAMysqlConfig.class, SandboxJTAOracleConfig.class })
public class SandboxJTADalConfig {
    @Bean(name = "userTransaction")
    public UserTransaction userTransaction() throws Throwable {
	UserTransactionImp userTransactionImp = new UserTransactionImp();
	userTransactionImp.setTransactionTimeout(10000);
	return userTransactionImp;
    }

    @Bean(name = "atomikosTransactionManager", initMethod = "init", destroyMethod = "close")
    public TransactionManager atomikosTransactionManager() throws Throwable {
	UserTransactionManager userTransactionManager = new UserTransactionManager();
	userTransactionManager.setForceShutdown(false);

	AtomikosJtaPlatform.transactionManager = userTransactionManager;

	return userTransactionManager;
    }

    @Bean(name = "transactionManager")
    @DependsOn({ "userTransaction", "atomikosTransactionManager" })
    public PlatformTransactionManager transactionManager() throws Throwable {
	UserTransaction userTransaction = userTransaction();

	AtomikosJtaPlatform.transaction = userTransaction;

	TransactionManager atomikosTransactionManager = atomikosTransactionManager();
	return new JtaTransactionManager(userTransaction, atomikosTransactionManager);
    }
}
