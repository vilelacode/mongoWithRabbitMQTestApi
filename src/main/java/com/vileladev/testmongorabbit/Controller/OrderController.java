package com.vileladev.testmongorabbit.Controller;

import com.vileladev.testmongorabbit.entity.Order;
import com.vileladev.testmongorabbit.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/customer/{customerId}/orders")
    public ResponseEntity<?> getOrdersByCustomer
            (
            @PathVariable("customerId") Long customerId,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
            )
    {
        var result = orderService.getOrdersByCustomer(customerId, PageRequest.of(page,size));
        return ResponseEntity.ok(result);
    }

}
