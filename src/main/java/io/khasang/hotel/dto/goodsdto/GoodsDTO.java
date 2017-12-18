package io.khasang.hotel.dto.goodsdto;

import io.khasang.hotel.entity.goods.Goods;
import io.khasang.hotel.entity.goods.Tag;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GoodsDTO {
    private long id;
    private String name;
//    private SkuDTO SkuDTO;
//    private ManufacturerDTO manufacturerDTO;
    private long barcode;
    private int price;
    private int stock;
    private String description;
    private Date date;
//    private CategoryDTO categoryDTO;
    private Set<TagDTO> tagDTOS;
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

//    public SkuDTO getSkuDTO() {
//        return SkuDTO;
//    }

//    public void setSkuDTO(SkuDTO skuDTO) {
//        this.SkuDTO = skuDTO;
//    }

//    public ManufacturerDTO getManufacturerDTO() {
//        return manufacturerDTO;
//    }

//    public void setManufacturerDTO(ManufacturerDTO manufacturerDTO) {
//        this.manufacturerDTO = manufacturerDTO;
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

//    public CategoryDTO getCategoryDTO() {
//        return categoryDTO;
//    }

//    public void setCategoryDTO(CategoryDTO categories) {
//        this.categoryDTO = categories;
//    }

    public Set<TagDTO> getTagDTOS() {
        return tagDTOS;
    }

    public void setTagDTOS(Set<TagDTO> tagDTOS) {
        this.tagDTOS = tagDTOS;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<GoodsDTO> getGoodsDTOList(List<Goods> goodsList) {
        List<GoodsDTO> goodsDTOS = new ArrayList<>();

        for (Goods goods : goodsList) {
         //   if (goods == null) return null;
            GoodsDTO goodsDTO = getGoodsDTO(goods);
            goodsDTOS.add(goodsDTO);
        }
        return goodsDTOS;
    }

    public GoodsDTO getGoodsDTO(Goods goods) {
        if(goods == null) return null;
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId(goods.getId());
        goodsDTO.setName(goods.getName());
//        goodsDTO.setSkuDTO(getSkuDTOFromGoods(goods));
//        goodsDTO.setManufacturerDTO(getManufacturerDTOFromGoods(goods));
        goodsDTO.setBarcode(goods.getBarcode());
        goodsDTO.setPrice(goods.getPrice());
        goodsDTO.setStock(goods.getStock());
        goodsDTO.setDescription(goods.getDescription());
        goodsDTO.setDate(goods.getDate());
//        goodsDTO.setCategoryDTO(getCategoryDTOFromGoods(goods));
        goodsDTO.setTagDTOS(getTagDTOSetFromGoods(goods));
        goodsDTO.setImage(goods.getImage());
        return goodsDTO;
    }

//    private SkuDTO getSkuDTOFromGoods(Goods goods) {
//        if(goods.getSku().getName() == null) return null;
//        SkuDTO skuDTO = new SkuDTO();
//        skuDTO.setId(goods.getSku().getId());
//        skuDTO.setName(goods.getSku().getName());
//        return skuDTO;
//    }

//    private ManufacturerDTO getManufacturerDTOFromGoods(Goods goods) {
//        ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
//        manufacturerDTO.setId(goods.getManufacturer().getId());
//        manufacturerDTO.setAddress(goods.getManufacturer().getAddress());
//        manufacturerDTO.setName(goods.getManufacturer().getName());
//        manufacturerDTO.setEmail(goods.getManufacturer().getEmail());
//        manufacturerDTO.setPhone(goods.getManufacturer().getPhone());
//        List<PersonDTO> personDTOS = getPersonDTOSFromGoods(goods);
//        manufacturerDTO.setContactListDTO(personDTOS);
//        return manufacturerDTO;
//    }

//    private List<PersonDTO> getPersonDTOSFromGoods(Goods goods) {
//        List<PersonDTO> personDTOS = new ArrayList<>();
//        for (Person person : goods.getManufacturer().getContactList()) {
//            PersonDTO personDTO = new PersonDTO();
//            personDTO.setId(person.getId());
//            personDTO.setFirstName(person.getFirstName());
//            personDTO.setLastName(person.getLastName());
//            personDTO.setPosition(person.getPosition());
//            personDTO.setPhone1(person.getPhone1());
//            personDTO.setPhone2(person.getPhone2());
//            personDTO.setEmail1(person.getEmail1());
//            personDTO.setEmail2(person.getEmail2());
//            personDTOS.add(personDTO);
//        }
//        return personDTOS;
//    }

//    private CategoryDTO getCategoryDTOFromGoods(Goods goods) {
//        CategoryDTO categoryDTO = new CategoryDTO();
//        categoryDTO.setId(goods.getCategory().getId());
//        categoryDTO.setName(goods.getCategory().getName());
//        return categoryDTO;
//    }

    private Set<TagDTO> getTagDTOSetFromGoods(Goods goods) {
        if(goods.getTags().size() == 0) return new HashSet<TagDTO>();
        Set<TagDTO> tagDTOS = new HashSet<>();
        for (Tag tag : goods.getTags()) {
            TagDTO tagDTO = new TagDTO();
            tagDTO.setId(tag.getId());
            tagDTO.setName(tag.getName());
            tagDTOS.add(tagDTO);
        }
        return tagDTOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsDTO goodsDTO = (GoodsDTO) o;

        return barcode == goodsDTO.barcode;
    }

    @Override
    public int hashCode() {
        return (int) (barcode ^ (barcode >>> 32));
    }
}

