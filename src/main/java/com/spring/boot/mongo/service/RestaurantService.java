package com.spring.boot.mongo.service;

import com.spring.boot.mongo.model.Restaurant;
import com.spring.boot.mongo.repository.RestaurantRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

  private final RestaurantRepository repository;
  private final SequenceGeneratorService sequenceGeneratorService;

  public RestaurantService(RestaurantRepository repository,
      SequenceGeneratorService sequenceGeneratorService) {
    this.repository = repository;
    this.sequenceGeneratorService = sequenceGeneratorService;
  }

  public Restaurant saveRestaurant(Restaurant restaurant) {
    restaurant.setId(sequenceGeneratorService.generateSequence(Restaurant.SEQUENCE_NAME));
    return repository.save(restaurant);
  }

  public List<Restaurant> getRestaurant() {
    return repository.findAll();
  }

  public Restaurant getRestaurantById(Long id) {
    Optional<Restaurant> result = repository.findById(id);
    return result.orElse(null);
  }

  public Restaurant updateRestaurant(Restaurant restaurant, Long id) {
    restaurant.setId(id);
    return repository.save(restaurant);
  }

  public String deleteRestaurant(Long id) {
    Optional<Restaurant> result = repository.findById(id);
    if (result.isPresent()) {
      repository.deleteById(id);
      return "Restaurant of id = '" + id + "' deleted successfully!!!";
    }
    return "Restaurant of id = '" + id + "' not found!!";
  }
}
