package com.stefanini.pizzariabackend.service;

import com.stefanini.pizzariabackend.domain.MenuItem;

import java.util.List;

/**
 * @author dcuciuc
 * @version 0.1
 * @since 0.1
 */
public interface MenuItemService {

    /**
     * Saves menu item.
     *
     * @param menuItem to be saved
     * @return saved menu item
     */
    MenuItem saveMenuItem(MenuItem menuItem);

    /**
     * Finds all menu items.
     *
     * @return all menu items or empty list
     */
    List<MenuItem> findAllMenuItems();

    /**
     * Deletes menu item by its id.
     *
     * @param id of menu item to be deleted
     * @return id of deleted menu item
     */
    Long deleteMenuItemById(Long id);
}
