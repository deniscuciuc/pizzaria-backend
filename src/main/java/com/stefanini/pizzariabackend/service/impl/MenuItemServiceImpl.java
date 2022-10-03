package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.MenuItem;
import com.stefanini.pizzariabackend.repo.MenuItemRepository;
import com.stefanini.pizzariabackend.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }


    @Override
    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> findAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public Long deleteMenuItemById(Long id) {
        menuItemRepository.deleteById(id);
        return id;
    }
}
