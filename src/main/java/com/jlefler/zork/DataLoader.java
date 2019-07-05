package com.jlefler.zork;

import com.jlefler.zork.house.House;
import com.jlefler.zork.house.Room;
import com.jlefler.zork.repository.HouseRepository;
import com.jlefler.zork.repository.RoleRepository;
import com.jlefler.zork.repository.RoomRepository;
import com.jlefler.zork.repository.UserRepository;
import com.jlefler.zork.security.Role;
import com.jlefler.zork.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role userRole = roleRepository.findByRole("USER");
        Role adminRole = roleRepository.findByRole("ADMIN");

        User user = new User("samazonpanther@gmail.com",passwordEncoder.encode("password"),"Bob","Bobberson",true,"bob");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        user = new User("admin@adm.com",passwordEncoder.encode("password"),"Admin","User",true,"admin");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);


        House house = new House();
        house.setName("Test");
        houseRepository.save(house);


        //Foyer
        Room room = new Room();
        room.setName("Foyer");
        room.setContent("a Dead Scorpion");
        room.setMoney(100.00);
        roomRepository.save(room);

        //Front Room
        room = new Room();
        room.setName("Front Room");
        room.setContent("a Piano");
        room.setMoney(103.00);
        roomRepository.save(room);

        //Library
        room = new Room();
        room.setName("Library");
        room.setContent("Spiders");
        room.setMoney(103.00);
        roomRepository.save(room);

        //Kitchen
        room = new Room();
        room.setName("Kitchen");
        room.setContent("Bats");
        room.setMoney(103.00);
        roomRepository.save(room);

        //Dining Room
        room = new Room();
        room.setName("Dining Room");
        room.setContent("Dust and an Empty Box");
        room.setMoney(103.00);
        roomRepository.save(room);

        //Vault
        room = new Room();
        room.setName("Vault");
        room.setContent("3 Walking Skeletons");
        room.setMoney(103.00);
        roomRepository.save(room);

        //Parlor
        room = new Room();
        room.setName("Parlor");
        room.setContent("Treasure Chest");
        room.setMoney(103.00);
        roomRepository.save(room);

        //Secret Room
        room = new Room();
        room.setName("Secret Room");
        room.setContent("Piles of Gold");
        room.setMoney(103.00);
        roomRepository.save(room);

    }
}
