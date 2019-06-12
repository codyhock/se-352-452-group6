package com.depaul.cdm.se452.group6.movie.service;

import com.depaul.cdm.se452.group6.movie.entity.PurchaseHistory;
import com.depaul.cdm.se452.group6.movie.finder.HistoryRepository;
import com.depaul.cdm.se452.group6.movie.utility.HistoryEntry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<PurchaseHistory> getAll() {
        try{
            List<PurchaseHistory> histories = historyRepository.findAll();
            return histories;
        } catch (Exception e ){
            return null;
        }
    }

    public PurchaseHistory getHistoryByUserId(Long userID) {
        try {
            PurchaseHistory history = historyRepository.findByUserID(userID);
            return history;
        } catch (Exception e) {
            return null;
        }
    }

    public PurchaseHistory pushHistory(Long userID, List<HistoryEntry> entries) {
        PurchaseHistory history = new PurchaseHistory();
        history.setUserID(userID);
        history.setEntries(entries);
        historyRepository.save(history);

        return history;

    }
}
