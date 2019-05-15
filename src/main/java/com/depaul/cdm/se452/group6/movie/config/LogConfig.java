package com.depaul.cdm.se452.group6.movie.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "log")
public class LogConfig {

  @Getter
  private String level;
}

