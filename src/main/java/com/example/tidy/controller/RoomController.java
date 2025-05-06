package com.example.tidy.controller;

import com.example.tidy.entity.Room;
import com.example.tidy.service.RoomService;
import com.example.tidy.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms().stream()
                .map(RoomDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RoomDTO getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public ResponseEntity<RoomDTO> createRoom(@Valid @RequestBody RoomDTO roomDTO) {
        RoomDTO createdRoom = roomService.createRoom(roomDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }
}
