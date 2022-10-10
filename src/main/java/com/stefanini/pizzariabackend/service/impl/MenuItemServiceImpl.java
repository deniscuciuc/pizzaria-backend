package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.MenuItem;
import com.stefanini.pizzariabackend.repo.MenuItemRepository;
import com.stefanini.pizzariabackend.service.MenuItemService;
import com.stefanini.pizzariabackend.service.impl.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Slf4j
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
    public MenuItem updateMenuItemById(Long id, MenuItem newMenuItem) {
        verifyIdIfExistAndIfNotThrowException(id);
        MenuItem oldMenuItem = menuItemRepository.findById(id).get();
        updateMenuItemFields(oldMenuItem, newMenuItem);
        return menuItemRepository.save(oldMenuItem);
    }

    @Override
    public List<MenuItem> findAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public Long deleteMenuItemById(Long id) {
        verifyIdIfExistAndIfNotThrowException(id);
        menuItemRepository.deleteById(id);
        return id;
    }

    private void verifyIdIfExistAndIfNotThrowException(Long id) throws NotFoundException {
        boolean doesMenuItemExist = menuItemRepository.existsById(id);
        if (!doesMenuItemExist) {
            log.error("Menu item with such id not found");
            throw new NotFoundException("Menu item with such id not found");
        }
    }

    private void updateMenuItemFields(MenuItem oldMenuItem, MenuItem newMenuItem) {
        oldMenuItem.setName(newMenuItem.getName());
        oldMenuItem.setImage(newMenuItem.getImage());
        oldMenuItem.setIngredients(newMenuItem.getIngredients());
        oldMenuItem.setCategory(newMenuItem.getCategory());
        oldMenuItem.setSubcategory(newMenuItem.getSubcategory());
        oldMenuItem.setSizesAndPrices(newMenuItem.getSizesAndPrices());
        oldMenuItem.setThickness(newMenuItem.getThickness());
        log.info("Menu item was updated");
    }
}
