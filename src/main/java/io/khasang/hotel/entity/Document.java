package io.khasang.hotel.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    /**
     * Type of the document:
     * Invoice, Contract, Report, SpreadSheet, Certificate, Identity, License ...
     */
    private String type;

    private String description;

//    private List<DocFile> docFiles;

    @Type(type = "timestamp")
    @Column(name = "creation_date")
    private Date creationDate;

    @Type(type = "timestamp")
    @Column(name = "modification_date")
    private Date modificationDate;

    @Column(name = "is_valid", columnDefinition = "boolean default true", nullable = false)
    /** Denotes whether the document is legally or officially acceptable */
    private boolean valid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
