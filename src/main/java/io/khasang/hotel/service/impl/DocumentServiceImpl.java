package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.DocumentDao;
import io.khasang.hotel.entity.Document;
import io.khasang.hotel.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DocumentService")
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public Document addDocument(Document document) {
        return documentDao.add(document);
    }

    @Override
    public Document getDocumentById(long id) {
        return documentDao.getById(id);
    }

    @Override
    public List<Document> getAllDocuments() {
        return documentDao.getList();
    }

    @Override
    public Document deleteDocument(long id) {
        return documentDao.delete(getDocumentById(id));
    }

    @Override
    public Document updateDocument(Document document) {
        return documentDao.update(document);
    }
}
