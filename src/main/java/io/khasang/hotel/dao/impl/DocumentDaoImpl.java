package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.DocumentDao;
import io.khasang.hotel.entity.Document;

public class DocumentDaoImpl extends BasicDaoImpl<Document> implements DocumentDao{
    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }
}
