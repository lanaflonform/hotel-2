package io.khasang.hotel.dto.goodsdto;

public class CategoryDTO {
    private long id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDTO categoryDTO = (CategoryDTO) o;

        return name.equals(categoryDTO.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
