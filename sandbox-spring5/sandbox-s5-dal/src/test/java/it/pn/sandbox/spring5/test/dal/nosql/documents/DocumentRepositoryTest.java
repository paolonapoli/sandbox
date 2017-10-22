/*
 * File DocumentRepositoryTest.java of project sandbox-s5-dal.
 * File created on 21 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.test.dal.nosql.documents;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import it.pn.sandbox.spring5.dal.nosql.documents.DocumentRepository;
import it.pn.sandbox.spring5.model.nosql.documents.Document;
import it.pn.sandbox.spring5.test.dal.conf.MongoDbTestConfig;

/**
 * Class DocumentRepositoryTest.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MongoDbTestConfig.class })
@Transactional
@Commit // does the COMMIT at the end
public class DocumentRepositoryTest {

    @Autowired
    private DocumentRepository documentRepository;

    /**
     * Constructor for the class.
     *
     */
    @Test
    public void testDocumentRepository() {
	this.documentRepository.deleteAll();

	// save a couple of customers
	this.documentRepository.save(new Document("htmldoc", "htmldoc explained", "text/html", "This is the content #1"));
	this.documentRepository.save(new Document("htmldoc2", "htmldoc2 explained", "text/html", "This is the content #2"));
	this.documentRepository.save(new Document("xmldoc", "xmldoc explained", "text/xml", "<example>This an XML content #1</example>"));
	this.documentRepository.save(new Document("xmldoc7", "xmldoc explained", "text/xml", "<example>This an XML content #7</example>"));
	this.documentRepository.save(new Document("htmldoc3", "htmldoc3 explained", "text/html", "This is the content #3"));
	this.documentRepository.save(new Document("binarydoc", "binarydoc explained", "application/binary", "This is the binary content".getBytes()));

	// fetch all customers
	System.out.println("Docs found with findAll():");
	System.out.println("-------------------------------");
	for (Document doc : this.documentRepository.findAll()) {
	    System.out.println(doc);
	}
	System.out.println();

	// fetch an individual customer
	System.out.println("Customer found with findByNameLikeIgnoreCase('htmldoc'):");
	System.out.println("--------------------------------");
	for (Document doc : this.documentRepository.findByNameLikeIgnoreCase("htmldoc")) {
	    System.out.println(doc);
	}

	System.out.println("Customers found with findByMimeType('text/xml'):");
	System.out.println("--------------------------------");
	for (Document doc : this.documentRepository.findByMimeType("text/xml")) {
	    System.out.println(doc);
	}
    }
}
