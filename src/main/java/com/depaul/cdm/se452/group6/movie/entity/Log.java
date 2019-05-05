package com.depaul.cdm.se452.group6.movie.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Document(collection = "logs")
public class Log implements Serializable {
  @Id
  @GeneratedValue
  private Long id;

  private String userName;
  private String action;
  private String result;
  private Date timeStamp;
}
