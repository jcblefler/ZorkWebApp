package com.jlefler.zork.repository;

import com.jlefler.zork.house.House;
import com.jlefler.zork.house.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findByName(String name);
    Room findByNameContainingIgnoreCase(String name);
//    Iterable<Room> findByHouse(House house);
}
