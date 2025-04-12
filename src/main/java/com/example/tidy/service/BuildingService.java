package com.example.tidy.service;

import com.example.tidy.entity.Building;
import com.example.tidy.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Optional<Building> getBuildingById(Integer id) {
        return buildingRepository.findById(id);
    }

    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public void deleteBuilding(Integer id) {
        buildingRepository.deleteById(id);
    }
}
