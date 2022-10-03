package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.Order;
import com.stefanini.pizzariabackend.repo.OrderRepository;
import com.stefanini.pizzariabackend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Long deleteOrderById(Long id) {
        orderRepository.deleteById(id);
        return id;
    }
}
