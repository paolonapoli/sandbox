/*
 * File SandboxDalConfig.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 14:49:13 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.conf;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Class SandboxDalConfig representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "it.pn.sandbox.spring5.dal.repository")
public class SandboxDalConfig {
    public final static String driver = "oracle.jdbc.driver.OracleDriver";
    public final static String address = "jdbc:oracle:thin:@localhost:1521:xe";

    @Bean
    public DataSource dataSource() {
	// naive (TODO: add pooling)
	DriverManagerDataSource ds = new DriverManagerDataSource();
	ds.setDriverClassName(driver);
	ds.setUrl(address);
	ds.setUsername("sandbox");
	ds.setPassword("sandbox");

	return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
	final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	vendorAdapter.setGenerateDdl(true);
	vendorAdapter.setShowSql(true);

	final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	factory.setJpaVendorAdapter(vendorAdapter);
	factory.setPackagesToScan("it.pn.sandbox.spring5.model");
	factory.setDataSource(dataSource());
	factory.afterPropertiesSet();

	// set
	return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
	return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
	return new HibernateExceptionTranslator();
    }
}
