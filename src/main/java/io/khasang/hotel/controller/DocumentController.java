package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Document;
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
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Document getDocumentById(@PathVariable(value = "id") String id) {
        return documentService.getDocumentById(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Document addDocument(@RequestBody Document document) {
        return documentService.addDocument(document);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Document deleteDocument(@RequestParam(value = "id") String id) {
        return documentService.deleteDocument(Long.parseLong(id));
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Document updateDocument(@RequestBody Document document) {
        return documentService.updateDocument(document);
    }
}
