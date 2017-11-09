package io.khasang.hotel.service.impl;

import io.khasang.hotel.service.MessageService;
import org.springframework.stereotype.Service;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessageInfo(String info) {
        return info;
    }
}
