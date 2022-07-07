package com.example.providerserver.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component // 使用了dubbo尽量不要使用service
public class TicketServiceImpl implements TicketService{

    @Override
    public String getTicket() {
        return "lks";
    }
}
