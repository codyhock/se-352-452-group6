package com.depaul.cdm.se452.group6.movie.model;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Seats {
  @NotNull
  Long[] selectedSeats;
}

