package com.example.tidy.controller;

import com.example.tidy.entity.Building;
import com.example.tidy.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping("/{id}")
    public Optional<Building> getBuildingById(@PathVariable Integer id) {
        return buildingService.getBuildingById(id);
    }

    @PostMapping
    public Building createBuilding(@RequestBody Building building) {
        return buildingService.saveBuilding(building);
    }

    @PutMapping("/{id}")
    public Building updateBuilding(@PathVariable Integer id, @RequestBody Building building) {
        building.setId(id);
        return buildingService.saveBuilding(building);
    }

    @DeleteMapping("/{id}")
    public void deleteBuilding(@PathVariable Integer id) {
        buildingService.deleteBuilding(id);
    }
}
