package com.example.tidy.controller;

import com.example.tidy.entity.Room;
import com.example.tidy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Optional<Room> getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }
}
