package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.MenuItem;
import com.stefanini.pizzariabackend.service.MenuItemService;
import com.stefanini.pizzariabackend.service.impl.MenuItemServiceImpl;
import com.stefanini.pizzariabackend.service.impl.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/menu-item/")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemServiceImpl menuItemServiceImpl) {
        this.menuItemService = menuItemServiceImpl;
    }

    @PostMapping("save")
    @ResponseStatus(CREATED)
    public MenuItem saveMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.saveMenuItem(menuItem);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateMenuItem(
            @PathVariable Long id,
            @RequestBody MenuItem newMenuItem
    ) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(menuItemService.updateMenuItemById(id, newMenuItem));
        } catch (NotFoundException exception) {
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(exception.getMessage());
        }
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
        } catch (NotFoundException exception) {
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(exception.getMessage());
        }
    }
}
