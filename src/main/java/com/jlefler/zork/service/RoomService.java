package com.jlefler.zork.service;

import com.jlefler.zork.house.House;
import com.jlefler.zork.house.Room;
import com.jlefler.zork.repository.HouseRepository;
import com.jlefler.zork.repository.RoomRepository;
import com.jlefler.zork.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    HouseService houseService;


    public void buildRooms(House house){

        Random random = new Random();
        ArrayList<Room> rooms = new ArrayList<Room>();

        //Foyer
        Room room = new Room();
        room.setName("Foyer");
        room.setRoomNumber(1);
        room.setContent("a Dead Scorpion");
        room.setMoney(random.nextInt(1001));
        roomRepository.save(room);
        rooms.add(room);

        //Front Room
        room = new Room();
        room.setName("Front Room");
        room.setRoomNumber(2);
        room.setContent("a Piano");
        room.setMoney(random.nextInt(1001));
        roomRepository.save(room);
        rooms.add(room);

        //Library
        room = new Room();
        room.setName("Library");
        room.setRoomNumber(3);
        room.setContent("Spiders");
        room.setMoney(random.nextInt(1001));
        roomRepository.save(room);
        rooms.add(room);

        //Kitchen
        room = new Room();
        room.setName("Kitchen");
        room.setRoomNumber(4);
        room.setContent("Bats");
        room.setMoney(random.nextInt(1001));
        roomRepository.save(room);
        rooms.add(room);

        //Dining Room
        room = new Room();
        room.setName("Dining Room");
        room.setRoomNumber(5);
        room.setContent("Dust and an Empty Box");
        room.setMoney(random.nextInt(1001));
        roomRepository.save(room);
        rooms.add(room);

        //Vault
        room = new Room();
        room.setName("Vault");
        room.setRoomNumber(6);
        room.setContent("3 Walking Skeletons");
        room.setMoney(random.nextInt(1001));
        roomRepository.save(room);
        rooms.add(room);

        //Parlor
        room = new Room();
        room.setName("Parlor");
        room.setRoomNumber(7);
        room.setContent("Treasure Chest");
        room.setMoney(random.nextInt(1001));
        roomRepository.save(room);
        rooms.add(room);

        //Secret Room
        room = new Room();
        room.setName("Secret Room");
        room.setRoomNumber(8);
        room.setContent("Piles of Gold");
        room.setMoney(random.nextInt(1001));
        roomRepository.save(room);
        rooms.add(room);

        houseService.addRooms(house, rooms);
        rooms.clear();

    }

    public void userSetRoom(House house, User user){
        for (Room room : house.getRooms()){
            if (room.getName().equalsIgnoreCase("Foyer")){
                user.setRoom(room);
            }
        }
    }

//    public void genRoomConnections(House house) {
//
////        if (house.getRooms().contains(roomRepository.findByName("Foyer").getId())){
////            Room room = roomRepository.findByName("Foyer");
////            room.setConnections(roomRepository.findByName("Front Room"));
////            roomRepository.save(room);
////        }
//
//            //Foyer
//            Room room = roomRepository.findByName("Foyer");
//            room.setConnections(roomRepository.findByName("Front Room"));
//            roomRepository.save(room);
//
//            //Front Room
//            room = roomRepository.findByNameContainingIgnoreCase("Front Room");
//            room.setConnections(roomRepository.findByName("Library"));
//            roomRepository.save(room);
//            room.setConnections(roomRepository.findByName("Kitchen"));
//            roomRepository.save(room);
//
//            //Library
//            Room library = roomRepository.findByName("Library");
//            library.setConnections(roomRepository.findByNameContainingIgnoreCase("Dining Room"));
//            roomRepository.save(library);
//
//            //Kitchen
//            Room kitchen = roomRepository.findByName("Kitchen");
//            kitchen.setConnections(roomRepository.findByName("Parlor"));
//            roomRepository.save(kitchen);
//
//            //Parlor
//            room = roomRepository.findByName("Parlor");
//            room.setConnections(roomRepository.findByName("Vault"));
//            roomRepository.save(room);
//
//            //Vault
//            room = roomRepository.findByName("Vault");
//            room.setConnections(roomRepository.findByNameContainingIgnoreCase("Secret Room"));
//            roomRepository.save(room);
//
//    }


}
