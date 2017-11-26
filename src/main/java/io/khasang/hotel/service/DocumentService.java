package io.khasang.hotel.service;

import io.khasang.hotel.entity.Document;

import java.util.List;

public interface DocumentService {
    /**
     * @param document - document that should be added.
     * @return added document
     */
    Document addDocument(Document document);

    /**
     * @param id - document id
     * @return document by id
     */
    Document getDocumentById(long id);

    /**
     * Method for receiving all documents.
     * @return list of all documents
     */
    List<Document> getAllDocuments();

    /**
     * @param id - document id
     * @return deleted document
     */
    Document deleteDocument(long id);

    /**
     * @param document - document that should be updated
     * @return updated document
     */
    Document updateDocument(Document document);
}
