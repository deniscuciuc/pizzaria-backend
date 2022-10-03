package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.History;
import com.stefanini.pizzariabackend.service.HistoryService;
import com.stefanini.pizzariabackend.service.impl.HistoryServiceImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/history/")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryServiceImpl historyServiceImpl) {
        this.historyService = historyServiceImpl;
    }

    @PostMapping("save")
    public History saveHistory(@RequestBody History history) {
        return historyService.saveHistory(history);
    }

    @GetMapping("findAll")
    public List<History> findAllHistories() {
        return historyService.findAllHistories();
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteHistoryById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(historyService.deleteHistoryById(id));
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body("History with such id not found");
        }
    }
}
