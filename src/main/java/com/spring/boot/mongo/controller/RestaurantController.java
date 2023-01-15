package com.spring.boot.mongo.controller;

import com.spring.boot.mongo.model.Restaurant;
import com.spring.boot.mongo.service.RestaurantService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

  private final RestaurantService restaurantService;

  public RestaurantController(RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  @PostMapping("/save-restaurant")
  public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
    return restaurantService.saveRestaurant(restaurant);
  }

  @GetMapping("/get-all-restaurant")
  public List<Restaurant> getRestaurant() {
    return restaurantService.getRestaurant();
  }

  @GetMapping("/get-restaurant-by-id/{id}")
  public Restaurant getRestaurantById(@PathVariable Long id) {
    return restaurantService.getRestaurantById(id);
  }

  @PatchMapping("/update-restaurant-info/{id}")
  public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
    return restaurantService.updateRestaurant(restaurant, id);
  }

  @DeleteMapping("/delete-restaurant-by-id/{id}")
  public String deleteRestaurant(@PathVariable Long id) {
    return restaurantService.deleteRestaurant(id);
  }

}
