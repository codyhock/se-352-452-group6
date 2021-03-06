package com.depaul.cdm.se452.group6.movie.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "user_types")
public class UserType implements Serializable {

    //Id, autogenerated
    @Id
    @GeneratedValue
    private Long id;

    //User Type
    private String type;

}
