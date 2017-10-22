/*
 * File SandboxJTAMysqlConfig.java of project sandbox-s5-dal.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.conf.jta;

import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.atomikos.jdbc.AtomikosDataSourceBean;

/**
 * Class SandboxJTAMysqlConfig.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.pn.sandbox.spring5.dal.mysql", entityManagerFactoryRef = "mysqlEntityManager", transactionManagerRef = "transactionManager")
@DependsOn("transactionManager")
public class SandboxJTAMysqlConfig {
    public static final String MYSQL_URL = "jdbc:mariadb://localhost:3306/sandbox";
    public static final String MYSQL_USER = "sandbox";
    public static final String MYSQL_PASSWORD = "Sandbox.123";

    @Bean("mysqlXADS")
    public DataSource dataSource() throws SQLException {

	MariaDbDataSource xads = new MariaDbDataSource();
	xads.setUrl(MYSQL_URL);
	xads.setUser(MYSQL_USER);
	xads.setPassword(MYSQL_PASSWORD);

	AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
	xaDataSource.setXaDataSource(xads);
	xaDataSource.setUniqueResourceName("MysqlXA");
	return xaDataSource;
    }

    @Bean(name = "mysqlEntityManager")
    public LocalContainerEntityManagerFactoryBean orderEntityManager() throws SQLException {
	// to use InnoDB
	System.setProperty("hibernate.dialect.storage_engine", "innodb");

	final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	vendorAdapter.setGenerateDdl(true);
	vendorAdapter.setShowSql(true);
	vendorAdapter.setDatabase(Database.MYSQL);

	HashMap<String, Object> properties = new HashMap<>();
	properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
	properties.put("javax.persistence.transactionType", "JTA");

	LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
	entityManager.setJtaDataSource(dataSource());
	entityManager.setJpaVendorAdapter(vendorAdapter);
	entityManager.setPackagesToScan("it.pn.sandbox.spring5.model.mysql");
	entityManager.setPersistenceUnitName("mysqlPersistenceUnit");
	entityManager.setJpaPropertyMap(properties);

	return entityManager;
    }

}
