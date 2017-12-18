package io.khasang.hotel.entity.goods;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NaturalId
    @Column(nullable = false, unique = true)
    private String name;
    @ManyToMany( mappedBy = "tags")
    @OrderColumn(name = "name")
    private Set<Goods> goodsSet = new HashSet<>();

    public Tag() {
    }

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

    public Set<Goods> getGoodsSet() {
        return goodsSet;
    }

    public void setGoodsSet(Set<Goods> goodsSet) {
        this.goodsSet = goodsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return name.equals(tag.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
