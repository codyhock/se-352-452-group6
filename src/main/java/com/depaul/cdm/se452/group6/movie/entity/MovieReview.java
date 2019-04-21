package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Document(collection = "reviews")
public class MovieReview implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private Long year;
  private int rating;
  private String comment;
}
