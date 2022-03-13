package com.project.assetmanageapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.assetmanageapp.entities.Asset;

public interface AssetDao  extends JpaRepository<Asset, Integer> {

	Optional<Asset> findByName(String name);

}
