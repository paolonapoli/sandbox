/*
 * File MongoDbTestConfig.java of project sandbox-s5-dal.
 * File created on 21 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.test.dal.conf;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import it.pn.sandbox.spring5.dal.conf.SandboxMongoConfig;

/**
 * Class MongoDbTestConfig.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@Import(SandboxMongoConfig.class)
public class MongoDbTestConfig {

    @Bean
    public DataSource dataSource() {
	EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).build();
	return db;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
	final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	vendorAdapter.setGenerateDdl(true);
	vendorAdapter.setShowSql(true);

	final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	factory.setJpaVendorAdapter(vendorAdapter);
	factory.setPackagesToScan("it.pn.sandbox.spring5.model.nosql");
	factory.setDataSource(dataSource());
	factory.afterPropertiesSet();

	// set
	return factory;
    }
    //

    @Bean
    public PlatformTransactionManager transactionMongoManager() throws SQLException {
	return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}
