package com.hospital.admin.service;
import com.hospital.admin.entity.Room;
import com.hospital.admin.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    // UPDATE ROOM
    public Room updateRoom(String roomNumber, Room updatedRoom) {
        Room room = roomRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setRoomType(updatedRoom.getRoomType());
        room.setAvailable(updatedRoom.isAvailable());
        room.setPrice(updatedRoom.getPrice());

        return roomRepository.save(room);
    }

    // DELETE ROOM
    public void deleteRoom(String roomNumber) {
        Room room = roomRepository.findById(roomNumber)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        roomRepository.delete(room);
    }
}
