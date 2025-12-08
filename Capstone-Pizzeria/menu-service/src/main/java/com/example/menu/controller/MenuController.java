package com.example.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.menu.entity.MenuItem;
import com.example.menu.service.MenuService;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private MenuService service;

    @PostMapping("/add")
    public MenuItem addMenuItem(@RequestBody MenuItem item) {
        return service.addItem(item);
    }

    @GetMapping("/all")
    public List<MenuItem> getAll() {
        return service.getAll();
    }

    @PutMapping("/update/{id}")
    public MenuItem update(@PathVariable Long id, @RequestBody MenuItem item) {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteItem(id);
    }

    @GetMapping("/search/{name}")
    public List<MenuItem> search(@PathVariable String name) {
        return service.searchByName(name);
    }

    @GetMapping("/category/{category}")
    public List<MenuItem> filterByCategory(@PathVariable String category) {
        return service.filterByCategory(category);
    }

    @GetMapping("/price/{max}")
    public List<MenuItem> filterByPrice(@PathVariable double max) {
        return service.filterByPrice(max);
    }
}
