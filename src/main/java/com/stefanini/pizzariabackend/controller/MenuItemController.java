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
@RequestMapping("/api/v1/menu-items")
public class MenuItemController {

    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemServiceImpl menuItemServiceImpl) {
        this.menuItemService = menuItemServiceImpl;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.saveMenuItem(menuItem);
    }

    @PutMapping("/{id}")
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
                    .status(exception.getResponseStatus())
                    .body(exception.getMessage());
        }
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.findAllMenuItems();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(menuItemService.deleteMenuItemById(id));
        } catch (NotFoundException exception) {
            return ResponseEntity
                    .status(exception.getResponseStatus())
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/pagination/sorting/{category}/{subcategory}/{current-page}/{page-size}/{sort-by}/{sort-order}")
    public ResponseEntity<?> getPaginatedAndSortedMenuItems(
            @PathVariable String category,
            @PathVariable String subcategory,
            @PathVariable("current-page") Long currentPage,
            @PathVariable("page-size") Long pageSize,
            @PathVariable("sort-by") String sortBy,
            @PathVariable("sort-order") String sortOrder
    ) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(menuItemService.getPaginatedAndSortedMenuItems(
                            category, subcategory, currentPage,
                            pageSize, sortBy, sortOrder
                    ));
        } catch (NotFoundException exception) {
            return ResponseEntity
                    .status(exception.getResponseStatus())
                    .body(exception.getMessage());
        }
    }
}
