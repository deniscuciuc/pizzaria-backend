package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.MenuItem;
import com.stefanini.pizzariabackend.service.MenuItemService;
import com.stefanini.pizzariabackend.service.impl.MenuItemServiceImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/menu-item/")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemServiceImpl menuItemServiceImpl) {
        this.menuItemService = menuItemServiceImpl;
    }

    @PostMapping("save")
    public MenuItem saveMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.saveMenuItem(menuItem);
    }

    @GetMapping("findAll")
    public List<MenuItem> findAllMenuItems() {
        return menuItemService.findAllMenuItems();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(menuItemService.deleteMenuItemById(id));
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body("Menu item with such id not found");
        }
    }
}
