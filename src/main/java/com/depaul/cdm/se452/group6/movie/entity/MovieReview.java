package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Document(collection = "reviews")
public class MovieReview implements Serializable {
  /*@Id
  @GeneratedValue
  private String _id;*/


  private Long userID;
  private String userName;
  private Long movieID;

  @NotNull
  private int rating;

  @NotNull
  private String comment;
}
