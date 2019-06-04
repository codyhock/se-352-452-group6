package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Document(collection = "reviews")
public class MovieReview implements Serializable {
  /*@Id
  @GeneratedValue
  private Long _id;*/

  private Long userID;
  private String userName;
  private Long movieID;
  private int rating;
  private String comment;
}
