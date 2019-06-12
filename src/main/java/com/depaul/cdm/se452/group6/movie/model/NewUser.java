package com.depaul.cdm.se452.group6.movie.model;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewUser {

  @NotNull
  private String firstname;

  @NotNull
  private String lastname;

  @NotNull
  private String email;

  @NotNull
  private String dateofbirth;

  @NotNull
  private String phonenumber;

  @NotNull
  private String usertypeid;

}
