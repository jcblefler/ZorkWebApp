package com.jlefler.zork.service;

import com.jlefler.zork.house.House;
import com.jlefler.zork.house.Room;
import com.jlefler.zork.repository.HouseRepository;
import com.jlefler.zork.repository.RoomRepository;
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

    public String displayText(String input, int roomNumber){

        switch (roomNumber){
            case 1:
        }
    }
}
