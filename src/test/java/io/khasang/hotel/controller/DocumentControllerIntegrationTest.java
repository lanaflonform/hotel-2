package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Document;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DocumentControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/document";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";
    private final String GET_BY_ID = "/get";

    @Test
    public void addDocument() {
        Document document = createDocument();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Document receivedDocument = responseEntity.getBody();
        assertNotNull(receivedDocument.getDescription());
    }

    @Test
    public void getAllDocuments() {
        createDocument();
        createDocument();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Document>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Document>>() {
                }
        );

        List<Document> documentList = responseEntity.getBody();
        assertNotNull(documentList.get(0));
        assertNotNull(documentList.get(1));
    }

    @Test
    public void deleteDocument() {
        Document document = createDocument();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Document.class,
                document.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Document receivedDocument = responseEntity.getBody();
        assertNotNull(receivedDocument.getDescription());

        ResponseEntity<Document> responseEntityForDeleteDocument = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Document.class,
                document.getId()
        );

        assertEquals("OK", responseEntityForDeleteDocument.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeleteDocument.getBody());
    }

    @Test
    public void updateDocument() {
        Document document = createDocument();
        document.setType("Report");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Document> httpEntity = new HttpEntity<>(document, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Document.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Document receivedDocument = responseEntity.getBody();
        assertNotNull(receivedDocument.getType());
        assertEquals("Report", receivedDocument.getType());
    }

    private Document createDocument() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Document document = prefillDocument("test-doc-1", "test-description-1");

        HttpEntity<Document> httpEntity = new HttpEntity<>(document, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Document createdDocument = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Document.class
        ).getBody();

        assertNotNull(createdDocument);
        assertEquals(document.getName(), createdDocument.getName());

        return createdDocument;
    }

    private Document prefillDocument(String name, String description) {
        Document document = new Document();
        document.setName(name);
        document.setDescription(description);
        document.setType("Test");
        Date today = new Date();
        document.setCreationDate(today);
        document.setModificationDate(today);
        document.setValid(false);
        return document;
    }
}
