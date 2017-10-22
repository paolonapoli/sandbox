/*
 * File DocumentRepository.java of project sandbox-s5-dal.
 * File created on 21 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.nosql.documents;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import it.pn.sandbox.spring5.model.nosql.documents.Document;

/**
 * Class DocumentRepository.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Repository
public interface DocumentRepository extends MongoRepository<Document, String> {

    public Set<Document> findByName(String name);

    public Set<Document> findByDescription(String description);

    public Set<Document> findByMimeType(String mimeType);

    public Set<Document> findByNameLikeIgnoreCase(String name);
}
