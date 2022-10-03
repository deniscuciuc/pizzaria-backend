package com.stefanini.pizzariabackend.repo;

import com.stefanini.pizzariabackend.domain.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}