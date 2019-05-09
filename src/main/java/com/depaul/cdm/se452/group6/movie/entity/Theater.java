package com.depaul.cdm.se452.group6.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table (
    name = "theaters",
    uniqueConstraints = { @UniqueConstraint(columnNames = {"theater", "time"} ) }
)
public class Theater implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int theater;
  private LocalDateTime time;

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