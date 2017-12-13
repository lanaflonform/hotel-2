package io.khasang.hotel.service;

import io.khasang.hotel.dto.DocumentDTO;

import java.util.List;

public interface DocumentService {
    /**
     * @param document - document that should be added.
     * @return added document
     */
    DocumentDTO addDocument(DocumentDTO document);

    /**
     * @param id - document id
     * @return document by id
     */
    DocumentDTO getDocumentById(long id);

    /**
     * Method for receiving all documents.
     * @return list of all documents DTOs
     */
    List<DocumentDTO> getAllDocuments();

    /**
     * @param id - document id
     * @return deleted document
     */
    DocumentDTO deleteDocument(long id);

    /**
     * @param document - document that should be updated
     * @return updated document
     */
    DocumentDTO updateDocument(DocumentDTO document);
}
