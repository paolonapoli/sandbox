/*
 * File SandboxMongoConfig.java of project sandbox-s5-dal.
 * File created on 21 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.conf;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.MongoClient;

/**
 * Class SandboxMongoConfig.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Configuration
@EnableTransactionManagement
@EnableMongoRepositories(basePackages = "it.pn.sandbox.spring5.dal.nosql")
public class SandboxMongoConfig extends AbstractMongoConfiguration {
    // TODO: externalize
    public static final String MONGO_ADDRESS = "localhost";
    public static final int MONGO_PORT = 27017;

    /*
     * (non-Javadoc)
     * @see org.springframework.data.mongodb.config.MongoConfigurationSupport#getDatabaseName()
     */
    @Override
    protected String getDatabaseName() {
	return "sandbox";
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongoClient()
     */
    @Override
    public MongoClient mongoClient() {
	return new MongoClient(MONGO_ADDRESS, MONGO_PORT);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.mongodb.config.MongoConfigurationSupport#getMappingBasePackages()
     */
    @Override
    protected Collection<String> getMappingBasePackages() {
	Collection<String> packages = new HashSet<>();
	packages.add("it.pn.sandbox.spring5.model.nosql");
	return packages;
    }
}
