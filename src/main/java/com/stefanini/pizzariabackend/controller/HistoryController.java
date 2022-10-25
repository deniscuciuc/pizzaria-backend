package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.History;
import com.stefanini.pizzariabackend.service.HistoryService;
import com.stefanini.pizzariabackend.service.impl.HistoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/histories")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryServiceImpl historyServiceImpl) {
        this.historyService = historyServiceImpl;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public History createHistory(@RequestBody History history) {
        return historyService.saveHistory(history);
    }

    @GetMapping
    public List<History> getAllHistories() {
        return historyService.findAllHistories();
    }
}
