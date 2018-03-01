package io.khasang.hotel.controller;

import io.khasang.hotel.dto.DocumentDTO;
import io.khasang.hotel.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<DocumentDTO> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public DocumentDTO getDocumentById(@PathVariable(value = "id") String id) {
        return documentService.getDocumentById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public DocumentDTO addDocument(@RequestBody DocumentDTO document) {
        return documentService.addDocument(document);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public DocumentDTO deleteDocument(@RequestParam(value = "id") String id) {
        return documentService.deleteDocument(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public DocumentDTO updateDocument(@RequestBody DocumentDTO document) {
        return documentService.updateDocument(document);
    }
}
