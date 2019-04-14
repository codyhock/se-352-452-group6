package com.depaul.cdm.se452.group6.movie.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@IdClass(TheaterPK.class)
@Table (name = "theaters")
public class Theater implements Serializable {
  @Id
  private Long theaterID;

  @Id
  private Long screen;

  @Id
  private Timestamp time;

  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumns({
      @JoinColumn(name = "movieName", referencedColumnName = "name", nullable = false),
      @JoinColumn(name = "movieYear", referencedColumnName = "year", nullable = false)
  })
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "id", nullable = false)
  private TheaterType theaterType;
}

class TheaterPK implements Serializable {
  private Long theaterID;
  private Long screen;
  private Timestamp time;
}