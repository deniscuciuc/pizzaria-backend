package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.History;
import com.stefanini.pizzariabackend.repo.HistoryRepository;
import com.stefanini.pizzariabackend.service.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public History saveHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public List<History> findAllHistories() {
        return historyRepository.findAll();
    }

    @Override
    public Long deleteHistoryById(Long id) {
        historyRepository.deleteById(id);
        return id;
    }
}
