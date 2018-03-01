package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Document;

import java.util.Date;

public class DocumentDTO {
    private Long id;
    private String name;
    private String type;
    private String description;
    private Date creationDate;
    private Date modificationDate;
    private boolean valid;

    public static DocumentDTO from(Document document) {
        if (document == null) {
            return null;
        }
        DocumentDTO dto = new DocumentDTO();
        dto.setId(document.getId());
        dto.setName(document.getName());
        dto.setType(document.getType());
        dto.setCreationDate(document.getCreationDate());
        dto.setModificationDate(document.getModificationDate());
        dto.setDescription(document.getDescription());
        dto.setValid(document.isValid());
        return dto;
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
