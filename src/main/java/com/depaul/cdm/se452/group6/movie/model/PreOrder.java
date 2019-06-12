package com.depaul.cdm.se452.group6.movie.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PreOrder {
  private Map<Long,Integer> foodCart;
  private Map<Long,Integer> drinkCart;
  private Map<Long,Integer> alcoholCart;
}
