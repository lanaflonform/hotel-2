package io.khasang.hotel.entity;

import io.khasang.hotel.dto.DocumentDTO;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Type of the document:
     * Invoice, Contract, Report, SpreadSheet, Certificate, Identity, License ...
     */
    private String type;

    private String description;

    // TODO: create DocFile entity, then add field List<DocFile> docFiles;

    @Type(type = "timestamp")
    @Column(name = "creation_date")
    private Date creationDate;

    @Type(type = "timestamp")
    @Column(name = "modification_date")
    private Date modificationDate;

    @Column(name = "is_valid", columnDefinition = "boolean default true", nullable = false)
    private boolean valid;

    public static Document from(DocumentDTO dto) {
        if (dto == null) {
            return null;
        }
        Document document = new Document();
        document.setId(dto.getId());
        document.setName(dto.getName());
        document.setType(dto.getType());
        document.setDescription(dto.getDescription());
        document.setCreationDate(dto.getCreationDate());
        document.setModificationDate(dto.getModificationDate());
        document.setValid(dto.isValid());
        return document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
