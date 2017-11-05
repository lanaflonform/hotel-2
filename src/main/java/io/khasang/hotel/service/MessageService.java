package io.khasang.hotel.service;

public interface MessageService {
    // на уровне интерфейса обязательно делаем javaDoc
    /**
     * This method required for display information
     *
     * @param info - detail info
     *
     * @return detailed info
     */
    public String getMessageInfo(String info);
}
