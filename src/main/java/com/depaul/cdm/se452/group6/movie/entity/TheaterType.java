package com.depaul.cdm.se452.group6.movie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "theater_types")
public class TheaterType {

  @Id
  @GeneratedValue
  private Long id;

  private String type;
}
