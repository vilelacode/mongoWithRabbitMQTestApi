package com.vileladev.testmongorabbit.listener;

import com.vileladev.testmongorabbit.dto.OrderCreatedDto;
import com.vileladev.testmongorabbit.services.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "order-created")
    public void listen(Message<OrderCreatedDto> message){
        System.out.println("Message received: " + message.getHeaders() + " / " + message.getPayload());
        orderService.saveOrder(message.getPayload());
    }

}
