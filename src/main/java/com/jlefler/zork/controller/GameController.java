package com.jlefler.zork.controller;

import com.jlefler.zork.house.House;
import com.jlefler.zork.house.Room;
import com.jlefler.zork.repository.HouseRepository;
import com.jlefler.zork.repository.UserRepository;
import com.jlefler.zork.security.User;
import com.jlefler.zork.service.HouseService;
import com.jlefler.zork.service.RoomService;
import com.jlefler.zork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class GameController {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoomService roomService;

    @Autowired
    HouseService houseService;



    @GetMapping("/newgame")
    public String newGame(Model model){
        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("house", new House());


        return "game/newgame";
    }

    @PostMapping("/postnewgame")
    public String processForm(@Valid House house, BindingResult result, Model model) {
        model.addAttribute("house", house);
        User user = userService.getCurrentUser();

        if (result.hasErrors()) {
            return "game/newgame";
        }

        houseRepository.save(house);



        return "redirect:/";
    }

    @RequestMapping("/housedetails/{id}")
    public String displayHouse(@PathVariable("id") long id, Model model){
        House house = houseRepository.findById(id).get();
        model.addAttribute("house",house);
        roomService.buildRooms(house);

        return "game/housedetails";
    }

    @RequestMapping("/playhouse/{id}")
    public String playHouse(@PathVariable("id") long id, Model model){
        House house = houseRepository.findById(id).get();
        User user = userService.getCurrentUser();
        house.setPlayers(user);
        houseRepository.save(house);
        user.setHouse(house);
        roomService.userSetRoom(house, user);
        userRepository.save(user);
        model.addAttribute("house",house);
//        roomService.genRoomConnections(house);

        return "redirect:/playhouse";
    }

    @GetMapping("/playhouse")
    public String play(Model model){
        User user = userService.getCurrentUser();
        House house = houseService.getCurrentHouse(user);

        model.addAttribute("house", house);
        model.addAttribute("user", user);
        model.addAttribute("room", user.getRoom());

        return "game/playhouse";
    }

    @PostMapping("/postplayhouse")
    public String postplay(Model model, @RequestParam("roomNumber") int roomNumber, @RequestParam("input") String input){
        User user = userService.getCurrentUser();
        House house = houseService.getCurrentHouse(user);
        Room room = houseService.getRoom(input, roomNumber, house);
        user.setRoom(room);
        userRepository.save(user);

        System.out.println(room.getName());


//        model.addAttribute("house", house);
//        model.addAttribute("user", user);
//        model.addAttribute("room", user.getRoom());


        return "redirect:/playhouse";
    }
}
