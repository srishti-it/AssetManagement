package com.project.assetmanageapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.assetmanageapp.dao.CategoryDao;
import com.project.assetmanageapp.entities.Category;

@RestController
public class BaseController {

	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * add category
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		try
		{
			return new ResponseEntity<>(categoryDao.save(category),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * get category list
	 * 
	 * @return
	 */
	@GetMapping("/category")
	public ResponseEntity<List<Category>> getCategory()
	{
		try
		{
			List<Category> list=categoryDao.findAll();
			if(list.isEmpty()||list.size()==0)
			{
				return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * update category list
	 * 
	 * @param id
	 * @param category
	 * @return
	 */
	@PutMapping("/category/{id}")
	public ResponseEntity<Object> updateCategory(@PathVariable Integer id, @RequestBody Category category)
	{
		/**
		 * take id and check if present and update 
		 */
		try
		{
			Optional<Category> categoryObj = categoryDao.findById(id);
			if(categoryObj.isPresent())
			{			
				categoryObj.get().setName(category.getName());
				categoryObj.get().setDescription(category.getDescription());
				//categoryObj.get().setId(category.getId());
				
				 return new ResponseEntity<>(categoryDao.save(categoryObj.get()),HttpStatus.OK);
			}
			 return new ResponseEntity<Object>("User doesn't exist",HttpStatus.NOT_FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}