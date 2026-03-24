package com.hospital.admin.controller;

import com.hospital.admin.entity.Room;
import com.hospital.admin.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // UPDATE
    @PutMapping("/{roomNumber}")
    public ResponseEntity<Room> updateRoom(
            @PathVariable String roomNumber,
            @RequestBody Room room) {

        return ResponseEntity.ok(roomService.updateRoom(roomNumber, room));
    }
    // DELETE
    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<String> deleteRoom(@PathVariable String roomNumber) {

        roomService.deleteRoom(roomNumber);
        return ResponseEntity.ok("Room deleted successfully");
    }
}
