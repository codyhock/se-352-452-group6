package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.PurchaseHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<PurchaseHistory,Long> {

    List<PurchaseHistory> findAll();
    PurchaseHistory findByUserID(Long userID);

}
