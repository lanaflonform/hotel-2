package io.khasang.hotel.entity.goods;

import io.khasang.hotel.entity.goods.manufacturer.Manufacturer;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // the product ID, assigned by DataBase when you create the product
    private long id;
    @Column(nullable = false)
    // the product name
    private String name;
    @OneToOne
    // the stock keeping unit
    private Sku sku;
    @OneToOne
    // the manufacturer
    private Manufacturer manufacturer;
    @Column(nullable = false)
    // the barcode
    private long barcode;
    @Column(nullable = true)
    // the current product price
    private int price;
    @Column(nullable = true)
    // the current stock level for the product
    private int stock;
    // the full product description
    private String description;
    @Type(type = "date")
    // the date that the product was added to the store
    private Date date;
    @OneToOne
    //  display the list of categories that the product is in
    private Category category;
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Tag.class, fetch = FetchType.EAGER)
    // the list of tags that the product is in
    private Set<Tag> tags;
    // the main product image
    private byte[] image;

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

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categories) {
        this.category = categories;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
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

