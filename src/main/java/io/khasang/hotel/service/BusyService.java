package io.khasang.hotel.service;

import io.khasang.hotel.entity.Busy;
import java.util.List;

public interface BusyService {
    /**
     * method for receiving all busy room
     * @return
     */
    List<Busy> getAllbusyRoom();

    /**
     * @param id = Busy id
     * @return Busy by id
     */
    Busy getBusyById(long id);

    /**
     * @param  - Busy that should be added to DB
     * @return Busy
     */
    Busy addBusy(Busy busy);

    /**
     * @param id - busy id for remove
     * @return  deleted busy
     * */
    Busy deleteBusy(long id);

}
