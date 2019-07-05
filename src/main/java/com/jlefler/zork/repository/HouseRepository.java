package com.jlefler.zork.repository;

import com.jlefler.zork.house.House;
import org.springframework.data.repository.CrudRepository;

public interface HouseRepository extends CrudRepository<House, Long> {
    House findByName(String name);
}
