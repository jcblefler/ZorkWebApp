package com.jlefler.zork.service;

import com.jlefler.zork.house.Room;
import com.jlefler.zork.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public void genRoomConnections() {

        //Foyer
        Room room = roomRepository.findByName("Foyer");
        room.setConnections(roomRepository.findByName("Front Room"));
        roomRepository.save(room);

        //Front Room
        room = roomRepository.findByNameContainingIgnoreCase("Front Room");
        room.setConnections(roomRepository.findByName("Library"));
        roomRepository.save(room);
        room.setConnections(roomRepository.findByName("Kitchen"));
        roomRepository.save(room);

        //Library
        Room library = roomRepository.findByName("Library");
        library.setConnections(roomRepository.findByNameContainingIgnoreCase("Dining Room"));
        roomRepository.save(library);

        //Kitchen
        Room kitchen = roomRepository.findByName("Kitchen");
        kitchen.setConnections(roomRepository.findByName("Parlor"));
        roomRepository.save(kitchen);

        //Parlor
        room = roomRepository.findByName("Parlor");
        room.setConnections(roomRepository.findByName("Vault"));
        roomRepository.save(room);

        //Vault
        room = roomRepository.findByName("Vault");
        room.setConnections(roomRepository.findByNameContainingIgnoreCase("Secret Room"));
        roomRepository.save(room);
    }


}
