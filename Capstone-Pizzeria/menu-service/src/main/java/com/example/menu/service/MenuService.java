package com.example.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.menu.entity.MenuItem;
import com.example.menu.exception.InvalidInputException;
import com.example.menu.exception.ResourceNotFoundException;
import com.example.menu.repo.MenuRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository repo;

//add
    public MenuItem addItem(MenuItem item) {

        if (item.getName() == null || item.getName().trim().isEmpty()) {
            throw new InvalidInputException("Item name cannot be empty");
        }

        if (item.getPrice() <= 0) {
            throw new InvalidInputException("Price must be greater than 0");
        }

        return repo.save(item);
    }

//getall
    public List<MenuItem> getAll() {
        return repo.findAll();
    }

    // UPDATE ITEM
    public MenuItem updateItem(Long id, MenuItem updated) {

        MenuItem item = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Menu item not found with ID: " + id));

        item.setName(updated.getName());
        item.setCategory(updated.getCategory());
        item.setPrice(updated.getPrice());
        item.setDescription(updated.getDescription());

        return repo.save(item);
    }

    // delete
    public void deleteItem(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Menu item not found with ID: " + id);
        }
        repo.deleteById(id);
    }

    public List<MenuItem> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    public List<MenuItem> filterByCategory(String category) {
        return repo.findByCategoryIgnoreCase(category);
    }

    public List<MenuItem> filterByPrice(double max) {
        return repo.findByPriceLessThanEqual(max);
    }
}
