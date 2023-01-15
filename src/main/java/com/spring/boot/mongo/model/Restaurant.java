package com.spring.boot.mongo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection = "restaurant")
public class Restaurant {

  @Transient
  public static final String SEQUENCE_NAME = "restaurant_sequence";

  @Id
  private Long id;
  private String name;
  private String address;
}
