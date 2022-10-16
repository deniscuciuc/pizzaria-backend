package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.Restaurant;
import com.stefanini.pizzariabackend.service.RestaurantService;
import com.stefanini.pizzariabackend.service.impl.RestaurantServiceImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantServiceImpl) {
        this.restaurantService = restaurantServiceImpl;
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }

    @GetMapping
    public List<Restaurant> findAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(restaurantService.deleteRestaurantById(id));
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body("Restaurant with such id not found");
        }
    }
}
