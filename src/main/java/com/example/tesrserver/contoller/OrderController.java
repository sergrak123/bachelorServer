package com.example.tesrserver.contoller;

import com.example.tesrserver.model.order.Order;
import com.example.tesrserver.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity createOrder(@RequestBody Order order) {
        try {
            return ResponseEntity.ok().body(orderService.createOrder(order).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Order error");
        }
    }
}
