package com.project.assetmanageapp.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.project.assetmanageapp.entities.Employee;

public interface Empdao extends JpaRepository<Employee, Integer> {

	
}
