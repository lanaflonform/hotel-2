package io.khasang.hotel.dto.goodsdto;

import io.khasang.hotel.entity.goods.Goods;
import io.khasang.hotel.entity.goods.Sku;
import io.khasang.hotel.entity.goods.Tag;
import io.khasang.hotel.entity.goods.manufacturer.Manufacturer;
import io.khasang.hotel.entity.goods.manufacturer.Person;

import java.util.*;

public class GoodsFactoryForTests {

    public Goods getTestGoods(){
        return createGoods();
    }

    private Goods createGoods() {
        Goods testGoods = new Goods();
        testGoods.setName("test goods");
//        testGoods.setSku(createSku());
//        testGoods.setManufacturer(createManufacturer());
        testGoods.setBarcode(1234567898765L);
        testGoods.setPrice(1001);
        testGoods.setStock(24);
        testGoods.setDescription("this line for test");
        testGoods.setDate(new Date());
//        testGoods.setCategory(createCategory());
//        testGoods.setTags(createTagSet());
        return testGoods;
    }

    private Set<Tag> createTagSet() {
        Set<Tag> tagSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            Tag tag = new Tag();
            tag.setName("test tag" + i);
            tagSet.add(tag);
        }
        return tagSet;
    }

//    private Category createCategory() {
//        Category category = new Category();
//        category.setName("test category");
//        return category;
//    }

    private Manufacturer createManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("test manufacturer");
        manufacturer.setAddress("test address");
        manufacturer.setPhone("333-222");
        manufacturer.setEmail("test@mail.io");
        manufacturer.setContactList(createContactList());
        return manufacturer;
    }

    private List<Person> createContactList() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Person person = new Person();
            person.setFirstName("Test first name " + i);
            person.setLastName("Test last name " + i);
            person.setPosition("test position");
            person.setPhone1("234-456-" + i);
            person.setPhone2("335-6783-" + i);
            person.setEmail1("test@mail.ru");
            person.setEmail2("test21@mail.ru");
            personList.add(person);
        }
        return personList;
    }

    private Sku createSku() {
        Sku sku = new Sku();
        sku.setName("kg");
        return sku;
    }
}
