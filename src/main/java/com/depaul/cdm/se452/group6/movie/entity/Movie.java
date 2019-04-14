package com.depaul.cdm.se452.group6.movie.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@IdClass(MoviePK.class)
@Table (name = "movies")
public class Movie implements Serializable {
  @Id
  private String name;

  @Id
  private Long year;

  private Double runtime;
  private String rating;
  private String genre;

  @OneToMany(cascade = CascadeType.ALL)
   private List<Theater> theaters;
}

class MoviePK implements Serializable {
  private String name;
  private Long year;
}
