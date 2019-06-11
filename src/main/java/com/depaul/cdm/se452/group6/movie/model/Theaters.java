package com.depaul.cdm.se452.group6.movie.model;

import com.depaul.cdm.se452.group6.movie.entity.Theater;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Theaters {
  @NotNull
  Long[] theaters;
}
