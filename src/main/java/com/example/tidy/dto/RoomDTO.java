package com.example.tidy.dto;

import com.example.tidy.entity.Room;

public class RoomDTO {
    private Integer id;
    private String name;
    private String description;
    private Integer buildingId;

    // Constructor from Entity
    public RoomDTO(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.description = room.getDescription();
        this.buildingId = room.getBuilding() != null ? room.getBuilding().getId() : null;
    }

    // Default constructor (needed for JSON deserialization)
    public RoomDTO() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

}
