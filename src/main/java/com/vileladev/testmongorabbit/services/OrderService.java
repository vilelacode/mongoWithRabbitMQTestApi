package com.vileladev.testmongorabbit.services;

import com.vileladev.testmongorabbit.dto.OrderCreatedDto;
import com.vileladev.testmongorabbit.entity.Order;
import com.vileladev.testmongorabbit.entity.OrderItem;
import com.vileladev.testmongorabbit.repositories.OrderRepository;
import com.vileladev.testmongorabbit.util.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private Logger logger = Logger.getLogger(OrderService.class.getName());

    public void saveOrder(OrderCreatedDto orderCreatedDto){

        try{

            var entity = new Order();
            entity.setId(orderCreatedDto.orderNumber());
            entity.setCustomerId(orderCreatedDto.customerId());
            entity.setDescription("Order created by customer " + orderCreatedDto.customerId());
            entity.setItems(getOrderItems(orderCreatedDto));
            getTotalValue(orderCreatedDto, entity);

            orderRepository.save(entity);
            logger.info("Order saved");

        }catch (Exception e){
            logger.severe("Error saving order: " + e.getMessage());
        }

    }

    private static void getTotalValue(OrderCreatedDto orderCreatedDto, Order entity) {
        entity.setTotalValue(orderCreatedDto
                .items()
                .stream()
                .map(item -> item.getPrice()
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.valueOf(0.0), BigDecimal::add));
    }

    private static List<OrderItem> getOrderItems(OrderCreatedDto orderCreatedDto) {
        return orderCreatedDto.items().stream().map(orderItem ->
                        new OrderItem(
                                orderItem.getProduct(), orderItem.getQuantity(), orderItem.getPrice())
                )
                .toList();
    }

    public Object getAllOrders() {
        return orderRepository.findAll();
    }

    public PageResponse findAllByCustomerId(Long customerId, PageRequest pageRequest) {
         var orders = orderRepository.findAllByCustomerId(customerId, pageRequest);

         return new PageResponse(orders);
    }



    public Object getOrdersByCustomer(Long customerId,PageRequest pageRequest) {
        return orderRepository.findAllByCustomerId(customerId, pageRequest);
    }
}
