/*
 * File SandboxMysqlConfig.java of project sandbox-s5-dal.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.conf;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Class SandboxMysqlConfig.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.pn.sandbox.spring5.dal.mysql", entityManagerFactoryRef = "mysqlEntityManager", transactionManagerRef = "mysqlTransactionManager")
public class SandboxMysqlConfig {
    public static final String MYSQL_DRIVER = "org.mariadb.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mariadb://localhost:3306/sandbox";
    public static final String MYSQL_USER = "sandbox";
    public static final String MYSQL_PASSWORD = "Sandbox.123";

    @Bean("mysqlDS")
    public DataSource dataSource() {
	BasicDataSource ds = new BasicDataSource();
	ds.setDriverClassName(MYSQL_DRIVER);
	ds.setUrl(MYSQL_URL);
	ds.setUsername(MYSQL_USER);
	ds.setPassword(MYSQL_PASSWORD);
	ds.setDefaultAutoCommit(false);
	ds.setEnableAutoCommitOnReturn(false);
	ds.setInitialSize(1);
	ds.setMaxTotal(5);

	return ds;
    }

    @Bean("mysqlEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	// to use InnoDB
	System.setProperty("hibernate.dialect.storage_engine", "innodb");

	final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	vendorAdapter.setGenerateDdl(true);
	vendorAdapter.setShowSql(true);
	vendorAdapter.setDatabase(Database.MYSQL);

	final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	factory.setJpaVendorAdapter(vendorAdapter);
	factory.setPackagesToScan("it.pn.sandbox.spring5.model.mysql");
	factory.setDataSource(dataSource());
	factory.afterPropertiesSet();

	// set
	return factory;
    }

    // @Primary
    @Bean("mysqlTransactionManager")
    public PlatformTransactionManager transactionManager() {
	return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}
