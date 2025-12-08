package com.example.menu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.menu.entity.MenuItem;


@Repository
public interface MenuRepository extends JpaRepository<MenuItem, Long> {
	
	  List<MenuItem> findByNameContainingIgnoreCase(String name);

	    List<MenuItem> findByCategoryIgnoreCase(String category);

	    List<MenuItem> findByPriceLessThanEqual(Double max);

}
