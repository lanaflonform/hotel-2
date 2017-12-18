package io.khasang.hotel.entity.goods;

//import io.khasang.hotel.entity.goods.manufacturer.Manufacturer;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** the product ID, assigned by DataBase when you create the product */
    private long id;
    @Column(nullable = false)
    /** the product name */
    private String name;
    //    @OneToOne
//    @JoinColumn(name = "sku_id")
//    /** the stock keeping unit */
//    private Sku sku;
//    @OneToOne
//    @JoinColumn(name = "manufacturer_id")
//    /** the manufacturer */
//    private Manufacturer manufacturer;
    /** the barcode */
    @NaturalId
    @Column(nullable = false, unique = true)
    private long barcode;
    @Column(nullable = true)
    /** the current product price */
    private int price;
    @Column(nullable = true)
    /** the current stock level of the product */
    private int stock;
    /**
     * the full product description
     */
    private String description;
    @Type(type = "date")
    /** the date that the product was added to the store */
    private Date date;
//    @OneToOne
//    @JoinColumn(name = "category_id")
//    /**  display the list of categories that the product is in */
//    private Category category;

    /**
     * the list of tags that the product is in
     */
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },
            fetch = FetchType.EAGER
    )
    @JoinTable(name = "goods_tags",
            joinColumns = @JoinColumn(name = "goods_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @OrderColumn(name = "name")
    private Set<Tag> tags = new HashSet<>();
    /**
     * the main product image
     */
    private byte[] image;

    public Goods() {
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

//    public Sku getSku() {
//        return sku;
//    }

//    public void setSku(Sku sku) {
//        this.sku = sku;
//    }

//    public Manufacturer getManufacturer() {
//        return manufacturer;
//    }

//    public void setManufacturer(Manufacturer manufacturer) {
//        this.manufacturer = manufacturer;
//    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public Category getCategory() {
//        return category;
//    }

//    public void setCategory(Category categories) {
//        this.category = categories;
//    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getGoodsSet().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getGoodsSet().remove(this);
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        return barcode == goods.barcode;
    }

    @Override
    public int hashCode() {
        return (int) (barcode ^ (barcode >>> 32));
    }
}

