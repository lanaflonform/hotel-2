package io.khasang.hotel.service.impl;

import io.khasang.hotel.dao.DocumentDao;
import io.khasang.hotel.dto.DocumentDTO;
import io.khasang.hotel.entity.Document;
import io.khasang.hotel.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("DocumentService")
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public DocumentDTO addDocument(DocumentDTO documentDTO) {
        return DocumentDTO.from(documentDao.add(Document.from(documentDTO)));
    }

    @Override
    public DocumentDTO getDocumentById(long id) {
        return DocumentDTO.from(documentDao.getById(id));
    }

    @Override
    public List<DocumentDTO> getAllDocuments() {
        List<Document> documentList = documentDao.getList();
        List<DocumentDTO> documentDTOList = new ArrayList<>();
        for (Document document : documentList) {
            documentDTOList.add(DocumentDTO.from(document));
        }
        return documentDTOList;
    }

    @Override
    public DocumentDTO deleteDocument(long id) {
        return DocumentDTO.from(documentDao.delete(documentDao.getById(id)));
    }

    @Override
    public DocumentDTO updateDocument(DocumentDTO documentDTO) {
        return DocumentDTO.from(documentDao.update(Document.from(documentDTO)));
    }
}
