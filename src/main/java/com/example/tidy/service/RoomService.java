package com.example.tidy.service;

import com.example.tidy.entity.Room;
import com.example.tidy.entity.Building;
import com.example.tidy.repository.RoomRepository;
import com.example.tidy.repository.BuildingRepository;
import com.example.tidy.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;
    private BuildingRepository buildingRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository,
            BuildingRepository buildingRepository) {
        this.roomRepository = roomRepository;
        this.buildingRepository = buildingRepository; // Initialize this
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public RoomDTO getRoomById(Integer id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        return new RoomDTO(room);
    }

    public RoomDTO createRoom(RoomDTO roomDTO) {
        // Validate building exists
        Building building = buildingRepository.findById(roomDTO.getBuildingId())
                .orElseThrow(() -> new RuntimeException("Building not found with id: " + roomDTO.getBuildingId()));

        Room room = new Room();
        room.setName(roomDTO.getName());
        room.setDescription(roomDTO.getDescription());
        room.setBuilding(building);

        Room savedRoom = roomRepository.save(room);
        return new RoomDTO(savedRoom);
    }

    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }
}
