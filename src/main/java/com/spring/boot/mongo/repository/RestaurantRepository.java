package com.spring.boot.mongo.repository;

import com.spring.boot.mongo.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, Long> {

}
