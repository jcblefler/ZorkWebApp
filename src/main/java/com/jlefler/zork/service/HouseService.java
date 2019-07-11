package com.jlefler.zork.service;

import com.jlefler.zork.house.House;
import com.jlefler.zork.house.Room;
import com.jlefler.zork.repository.HouseRepository;
import com.jlefler.zork.repository.RoomRepository;
import com.jlefler.zork.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;

@Service
public class HouseService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HouseRepository houseRepository;


    public void addRooms(House house, ArrayList<Room> rooms) {

        for (Room room : rooms){
            house.setRooms(room);
            houseRepository.save(house);
        }
    }

    public House getCurrentHouse(User user){
        House house = user.getHouse();

        return house;
    }

    public Room getRoom(String input, int roomNumber, House house){

        ArrayList<Room> rooms = new ArrayList<>();
        for (Room room : house.getRooms()){
            rooms.add(room);
        }

        switch (roomNumber){
            case 1: if (input.equalsIgnoreCase("north")){
                Room room = houseRepository.findByName("Front Room");
                return room;
            } break;
            case 2: if (input.equalsIgnoreCase("east")){
                Room room = houseRepository.findByName("Kitchen");
                return room;
            } else if (input.equalsIgnoreCase("west")){
                Room room = houseRepository.findByName("Library");
                return room;
            } else if (input.equalsIgnoreCase("south")){
                Room room = houseRepository.findByName("Kitchen");
                return room;
            } break;
            case 3: if (input.equalsIgnoreCase("north")){
                Room room = houseRepository.findByName("Dining Room");
                return room;
            } else if (input.equalsIgnoreCase("east")){
                Room room = houseRepository.findByName("Front Room");
                return room;
            } break;
            case 4: if (input.equalsIgnoreCase("north")){
                Room room = houseRepository.findByName("Parlor");
                return room;
            } else if (input.equalsIgnoreCase("west")){
                Room room = houseRepository.findByName("Front Room");
                return room;
            } break;
            case 5: if (input.equalsIgnoreCase("south")){
                Room room = houseRepository.findByName("Library");
                return room;
            } break;
            case 6: if (input.equalsIgnoreCase("east")){
                Room room = houseRepository.findByName("Parlor");
                return room;
            } break;
            case 7: if (input.equalsIgnoreCase("west")){
                Room room = houseRepository.findByName("Vault");
                return room;
            } else if (input.equalsIgnoreCase("south")){
                Room room = houseRepository.findByName("Kitchen");
                return room;
            } break;
            case 8: if (input.equalsIgnoreCase("west")){
                Room room = houseRepository.findByName("Vault");
                return room;
            } break;
        }
        Room room = houseRepository.findByName("Foyer");
        return room;
    }
}
