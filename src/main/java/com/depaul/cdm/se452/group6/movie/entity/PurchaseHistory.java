package com.depaul.cdm.se452.group6.movie.entity;

import com.depaul.cdm.se452.group6.movie.utility.HistoryEntry;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "purchasehistory")
public class PurchaseHistory implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private long userID;

    private List<HistoryEntry> entries;

}