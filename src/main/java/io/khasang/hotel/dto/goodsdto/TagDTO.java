package io.khasang.hotel.dto.goodsdto;

import java.util.Set;


public class TagDTO {
    private long id;
    private String name;
    private Set<GoodsDTO> goodsDTOSet;

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

    public Set<GoodsDTO> getGoodsDTOSet() {
        return goodsDTOSet;
    }

    public void setGoodsDTOSet(Set<GoodsDTO> goodsDTOSet) {
        this.goodsDTOSet = goodsDTOSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagDTO tagDTO = (TagDTO) o;

        return name.equals(tagDTO.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
