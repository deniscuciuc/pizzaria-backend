package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.Restaurant;
import com.stefanini.pizzariabackend.repo.RestaurantRepository;
import com.stefanini.pizzariabackend.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Long deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
        return id;
    }
}
