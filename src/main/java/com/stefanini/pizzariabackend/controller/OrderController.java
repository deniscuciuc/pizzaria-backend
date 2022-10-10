package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.Order;
import com.stefanini.pizzariabackend.service.OrderService;
import com.stefanini.pizzariabackend.service.impl.OrderServiceImpl;
import com.stefanini.pizzariabackend.service.impl.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/order/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderService = orderServiceImpl;
    }

    @PostMapping("save")
    @ResponseStatus(CREATED)
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("findAll")
    public List<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(orderService.deleteOrderById(id));
        } catch (NotFoundException exception) {
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(exception.getMessage());
        }
    }
}
