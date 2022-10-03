package com.stefanini.pizzariabackend.service;

import com.stefanini.pizzariabackend.domain.History;

import java.util.List;

/**
 * @author dcuciuc
 * @version 0.1
 * @since 0.1
 */
public interface HistoryService {

    /**
     * Saves history item.
     *
     * @param history to be saved
     * @return saved history
     */
    History saveHistory(History history);

    /**
     * Finds all histories.
     *
     * @return all histories or empty list
     */
    List<History> findAllHistories();

    /**
     * Deletes history by its id.
     *
     * @param id of history item to be deleted
     * @return id of delete history
     */
    Long deleteHistoryById(Long id);
}
