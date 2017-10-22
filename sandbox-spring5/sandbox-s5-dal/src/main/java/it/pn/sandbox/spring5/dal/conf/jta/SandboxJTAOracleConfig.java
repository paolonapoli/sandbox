/*
 * File SandboxJTAOracleConfig.java of project sandbox-s5-dal.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.conf.jta;

import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.atomikos.jdbc.AtomikosDataSourceBean;

import oracle.jdbc.xa.client.OracleXADataSource;

/**
 * Class SandboxJTAOracleConfig.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.pn.sandbox.spring5.dal.sql", entityManagerFactoryRef = "oracleEntityManager", transactionManagerRef = "transactionManager")
@DependsOn("transactionManager")
public class SandboxJTAOracleConfig {
    public static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String ORACLE_USER = "sandbox";
    public static final String ORACLE_PASSWORD = "sandbox";

    @Bean("oracleXADS")
    public DataSource dataSource() throws SQLException {

	OracleXADataSource xads = new OracleXADataSource();
	xads.setURL(ORACLE_URL);
	xads.setUser(ORACLE_USER);
	xads.setPassword(ORACLE_PASSWORD);

	AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
	xaDataSource.setXaDataSource(xads);
	xaDataSource.setUniqueResourceName("OracleXA");
	return xaDataSource;
    }

    @Bean(name = "oracleEntityManager")
    public LocalContainerEntityManagerFactoryBean orderEntityManager() throws SQLException {
	final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	vendorAdapter.setGenerateDdl(true);
	vendorAdapter.setShowSql(true);
	vendorAdapter.setDatabase(Database.ORACLE);

	HashMap<String, Object> properties = new HashMap<>();
	properties.put("hibernate.transaction.jta.platform", AtomikosJtaPlatform.class.getName());
	properties.put("javax.persistence.transactionType", "JTA");

	LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
	entityManager.setJtaDataSource(dataSource());
	entityManager.setJpaVendorAdapter(vendorAdapter);
	entityManager.setPackagesToScan("it.pn.sandbox.spring5.model.sql");
	entityManager.setPersistenceUnitName("oraclePersistenceUnit");
	entityManager.setJpaPropertyMap(properties);

	return entityManager;
    }
}
