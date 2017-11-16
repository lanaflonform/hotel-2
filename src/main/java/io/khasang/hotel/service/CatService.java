package io.khasang.hotel.service;

import io.khasang.hotel.entity.Cat;

import java.util.List;

public interface CatService {
    /**
     * method for receiving all cats
     *
     * @return all cats
     * */
    List<Cat> getAllCats();

    /**
     * @param id = cat id
     *
     * @return Cat by id
     * */
    Cat getCatById(long id);
}
