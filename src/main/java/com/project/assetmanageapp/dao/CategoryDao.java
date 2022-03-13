package com.project.assetmanageapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.assetmanageapp.entities.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

	//Object saveAll(Optional<Category> categoryObj);

}
