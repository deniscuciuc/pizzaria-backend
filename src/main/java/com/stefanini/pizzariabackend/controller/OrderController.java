package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.Order;
import com.stefanini.pizzariabackend.service.OrderService;
import com.stefanini.pizzariabackend.service.impl.OrderServiceImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/order/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderService = orderServiceImpl;
    }

    @PostMapping("save")
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
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body("Order with such id not found");
        }
    }
}
