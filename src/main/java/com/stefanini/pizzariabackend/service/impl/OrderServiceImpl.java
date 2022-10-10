package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.Order;
import com.stefanini.pizzariabackend.repo.OrderRepository;
import com.stefanini.pizzariabackend.service.OrderService;
import com.stefanini.pizzariabackend.service.impl.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        verifyIdIfExistAndIfNotThrowException(id);
        orderRepository.deleteById(id);
        return id;
    }

    private void verifyIdIfExistAndIfNotThrowException(Long id) {
        boolean doesOrderExist = orderRepository.existsById(id);
        if (!doesOrderExist) {
            log.error("Order with such id not found");
            throw new NotFoundException("Order with such id not found");
        }
    }

}
