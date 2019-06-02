package com.depaul.cdm.se452.group6.movie.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Document(collection = "reviews")
public class PurchaseHistory {

    @Id
    @GeneratedValue
    private long id;

    private Date timestamp;

    private Cart cart;

}
