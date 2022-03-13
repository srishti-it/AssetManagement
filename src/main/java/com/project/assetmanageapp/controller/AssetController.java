package com.project.assetmanageapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.assetmanageapp.constant.Status;
import com.project.assetmanageapp.dao.AssetDao;
import com.project.assetmanageapp.dao.Empdao;
import com.project.assetmanageapp.entities.Asset;
import com.project.assetmanageapp.entities.Category;
import com.project.assetmanageapp.entities.Employee;

@RestController
public class AssetController {

	/**
	 * jpa repository object
	 */
	@Autowired
	private AssetDao assetDao;
	
	@Autowired
	private Empdao empDao;
	
	/**
	 * add asset
	 * 
	 * @param asset
	 * @return save asset
	 */
	@PostMapping("/asset")
	public ResponseEntity<Asset> addAsset(@RequestBody Asset asset)
	{
		try
		{
			return new ResponseEntity<>(assetDao.save(asset),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * get list of assets
	 * 
	 * @return asset list
	 */
	
	@GetMapping("/asset")
	public ResponseEntity<List<Asset>> getAsset()
	{
		/**
		 * get asset list
		 * and check if empty then return httpstatus
		 * else'
		 * return list asset
		 */
		try
		{
			List<Asset> list=assetDao.findAll();
			if(list.isEmpty()||list.size()==0)
			{
				return new ResponseEntity<List<Asset>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Asset>>(list,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * assign asset to employee
	 * 
	 * @param assetId
	 * @param empId
	 * @return
	 */
	@PutMapping("/assign")
	public ResponseEntity<Object> assignAssetToEmp(@RequestParam Integer assetId, @RequestParam Integer empId) {
		
		/**
		 * check if asset is present if present 
		 * check for employee present if  present
		 * assign asset and update status to assigned
		 */
		try {
			Optional<Asset> asset = assetDao.findById(assetId);
			Optional<Employee> emp = empDao.findById(empId);
			if (asset.isPresent() && asset.get().getStatus().equals(Status.AVAILABLE)) {
				if (emp.isPresent()) {
					asset.get().setEmployee(emp.get());
					asset.get().setStatus(Status.ASSIGNED);
					return new ResponseEntity<Object>(assetDao.save(asset.get()), HttpStatus.OK);
				}
				return new ResponseEntity<Object>("User not present", HttpStatus.NOT_FOUND);

			}

			return new ResponseEntity<Object>("Asset not present", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * search for an asset by name
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/asset-search")
	public ResponseEntity<Object> searchAsset(@RequestParam String name)
	{
		/**
		 * check for name present in asset
		 */
		try {
			Optional<Asset> asset = assetDao.findByName(name);
			if (asset.isPresent()) {
				return new ResponseEntity<Object>(asset.get(), HttpStatus.OK);
			}
			return new ResponseEntity<Object>("Asset not present", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * delete an asset using id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/asset/{id}")
	public ResponseEntity<Object> deleteAsset(@PathVariable Integer id)
	{
		/**
		 * find by id and compare if present and status assigned
		 * to delete
		 */
		try {
			Optional<Asset> asset = assetDao.findById(id);
			if (asset.isPresent() && !asset.get().getStatus().equals(Status.ASSIGNED)) {
				return new ResponseEntity<Object>("Asset deleted successfully", HttpStatus.OK);
			}

			return new ResponseEntity<Object>("Asset not present or already assigned to someone", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * update an asset and change its status
	 * 
	 * @param id
	 * @param asset
	 * @return
	 */
	@PutMapping("/asset/{id}")
	public ResponseEntity<Object> updateAsset(@PathVariable Integer id, @RequestBody Asset asset)
	{

		/**
		 * check if asset present
		 * and set values
		 */
		try {
			Optional<Asset> assetObj = assetDao.findById(id);
			if (assetObj.isPresent()) {
				assetObj.get().setName(asset.getName());
				assetObj.get().setConditionNote(asset.getConditionNote());
				assetObj.get().setCategory(asset.getCategory());
				assetObj.get().setEmployee(asset.getEmployee());
				assetObj.get().setPurchaseDate(asset.getPurchaseDate());
				assetObj.get().setStatus(asset.getStatus());
				// categoryObj.get().setId(category.getId());

				return new ResponseEntity<>(assetDao.save(assetObj.get()), HttpStatus.OK);
			}
			return new ResponseEntity<Object>("Asset doesn't exist", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
