package com.depaul.cdm.se452.group6.movie.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table (
    name = "theaters",
    uniqueConstraints = { @UniqueConstraint(columnNames = {"theater", "time"} ) }
)
public class Theater implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  private Long theater;
  private Timestamp time;

  @ManyToOne
  @JoinColumn(name = "movieID", nullable = false)
  private Movie movieID;

  @ManyToOne
  @JoinColumn(name = "theaterType", nullable = false)
  private TheaterType theaterType;
}