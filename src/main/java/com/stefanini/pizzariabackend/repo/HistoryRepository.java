package com.stefanini.pizzariabackend.repo;

import com.stefanini.pizzariabackend.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
