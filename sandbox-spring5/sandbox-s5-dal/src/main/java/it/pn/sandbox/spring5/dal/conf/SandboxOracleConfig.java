/*
 * File SandboxOracleConfig.java of project sandbox-s5-dal.
 * File created on 21 ott 2017 at 02:13:41 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Class SandboxOracleConfig representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.pn.sandbox.spring5.dal.sql", entityManagerFactoryRef = "oracleEntityManager", transactionManagerRef = "oracleTransactionManager")
public class SandboxOracleConfig {
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String ORACLE_USER = "sandbox";
    public static final String ORACLE_PASSWORD = "sandbox";

    @Bean("oracleDS")
    public DataSource dataSource() {
	BasicDataSource ds = new BasicDataSource();
	ds.setDriverClassName(ORACLE_DRIVER);
	ds.setUrl(ORACLE_URL);
	ds.setUsername(ORACLE_USER);
	ds.setPassword(ORACLE_PASSWORD);
	ds.setDefaultAutoCommit(false);
	ds.setEnableAutoCommitOnReturn(false);
	ds.setInitialSize(1);
	ds.setMaxTotal(5);

	return ds;
    }

    @Bean("oracleEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	vendorAdapter.setGenerateDdl(true);
	vendorAdapter.setShowSql(true);
	vendorAdapter.setDatabase(Database.ORACLE);

	final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	factory.setJpaVendorAdapter(vendorAdapter);
	factory.setPackagesToScan("it.pn.sandbox.spring5.model.sql");
	factory.setDataSource(dataSource());
	factory.afterPropertiesSet();

	// set
	return factory;
    }

    @Primary
    @Bean("oracleTransactionManager")
    public PlatformTransactionManager transactionManager() {
	return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}
