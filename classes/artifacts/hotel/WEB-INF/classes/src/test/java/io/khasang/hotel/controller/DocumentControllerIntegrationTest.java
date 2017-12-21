package io.khasang.hotel.controller;

import io.khasang.hotel.dto.DocumentDTO;
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
        DocumentDTO dto = createDocument("Add document", "Add description");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DocumentDTO> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                DocumentDTO.class,
                dto.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        DocumentDTO receivedDTO = responseEntity.getBody();
        assertNotNull(receivedDTO.getDescription());
    }

    @Test
    public void getAllDocuments() {
        createDocument("GetAll document 1", "GetAll description 1");
        createDocument("GetAll document 2", "GetAll description 2");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<DocumentDTO>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<DocumentDTO>>() {
                }
        );

        List<DocumentDTO> documentList = responseEntity.getBody();
        assertNotNull(documentList.get(0));
        assertNotNull(documentList.get(1));
    }

    @Test
    public void deleteDocument() {
        DocumentDTO dto = createDocument("Delete document", "Delete description");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DocumentDTO> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                DocumentDTO.class,
                dto.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        DocumentDTO receivedDTO = responseEntity.getBody();
        assertNotNull(receivedDTO.getDescription());

        ResponseEntity<DocumentDTO> responseEntityForDeleteDocument = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                DocumentDTO.class,
                dto.getId()
        );

        assertEquals("OK", responseEntityForDeleteDocument.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeleteDocument.getBody());
    }

    @Test
    public void updateDocument() {
        DocumentDTO dto = createDocument("Update document", "Update description");
        dto.setType("Report");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<DocumentDTO> httpEntity = new HttpEntity<>(dto, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DocumentDTO> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                DocumentDTO.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        DocumentDTO receivedDTO = responseEntity.getBody();
        assertNotNull(receivedDTO.getType());
        assertEquals("Report", receivedDTO.getType());
    }

    private DocumentDTO createDocument(String name, String description) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        DocumentDTO dto = prefillDocumentDTO(name, description);

        HttpEntity<DocumentDTO> httpEntity = new HttpEntity<>(dto, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        DocumentDTO createdDTO = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                DocumentDTO.class
        ).getBody();

        assertNotNull(createdDTO);
        assertEquals(dto.getName(), createdDTO.getName());

        return createdDTO;
    }

    private DocumentDTO prefillDocumentDTO(String name, String description) {
        DocumentDTO dto = new DocumentDTO();
        dto.setName(name);
        dto.setDescription(description);
        dto.setType("Test");
        Date today = new Date();
        dto.setCreationDate(today);
        dto.setModificationDate(today);
        dto.setValid(false);
        return dto;
    }
}
