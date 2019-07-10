package com.jlefler.zork.controller;

import com.jlefler.zork.house.House;
import com.jlefler.zork.repository.HouseRepository;
import com.jlefler.zork.security.User;
import com.jlefler.zork.service.RoomService;
import com.jlefler.zork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class GameController {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    UserService userService;

    @Autowired
    RoomService roomService;




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
        model.addAttribute("house",house);
//        roomService.genRoomConnections(house);

        return "game/playhouse";
    }
}
