package com.depaul.cdm.se452.group6.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
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
  @JsonIgnore
  private Movie movieID;

  @ManyToOne
  @JoinColumn(name = "theaterType", nullable = false)
  private TheaterType theaterType;

  @OneToMany(
      mappedBy = "theater",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY
  )
  @ToString.Exclude
  @JsonIgnore
  private List<Seat> seats;
}