package io.khasang.hotel.service;

import io.khasang.hotel.dto.InfoDTO;
import io.khasang.hotel.entity.Info;

import java.util.Set;

public interface InfoService {
    /**
     * method for receiving all info
     *
     * @return all info
     */
    Set<InfoDTO> getAllInfo();

    /**
     * @param id = info id
     * @return info by id
     */
    Info getInfoById(long id);

    /**
     * @param info - info that should be added to DB
     * @return info
     */
    Info addInfo(Info info);


    /**
     * @param info - info that should be updated to DB
     * @return info
     */
    Info updateInfo(Info info);

    /**
     * @param id - info id for remove
     * @return  deleted info
     * */
    Info deleteInfo(long id);
}
