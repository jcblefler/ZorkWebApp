package com.jlefler.zork.controller;

import com.jlefler.zork.house.House;
import com.jlefler.zork.house.Room;
import com.jlefler.zork.repository.HouseRepository;
import com.jlefler.zork.repository.RoomRepository;
import com.jlefler.zork.security.User;
import com.jlefler.zork.service.RoomService;
import com.jlefler.zork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Arrays;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    HouseRepository houseRepository;


    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());


        return "security/registration";
    }

    @PostMapping("/register")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result,  Model model, @RequestParam("role") String role, @RequestParam("password") String password){

        model.addAttribute("user",user);
        if(result.hasErrors()) {
            return "/security/registration";
        }
        else {
            if(userService.getCurrentUser() != null){
                user.setId(userService.getCurrentUser().getId());
                user.setPassword(password);
                userService.saveUser(user, role);
            } else {
                user.setPassword(password);
                userService.saveUser(user, role);
            }
        }

        return "security/index";
    }

    @RequestMapping("/")
    public String index(Model model) {


        User user = userService.getCurrentUser();

        House house = houseRepository.findByName("Test");
        house.setRooms(roomRepository.findByName("Foyer"));
        houseRepository.save(house);

        roomService.genRoomConnections();

        return "security/index";
    }

    @RequestMapping ("/login")
    public String login() {

        return "security/login";
    }


    @RequestMapping("/secure")
    public String secure(Model model) {
        // Gets the currently logged in user and maps it to "user" in the Thymeleaf template
        model.addAttribute("user", userService.getCurrentUser());

        User user = userService.getCurrentUser();

        return "security/secure";
    }



    /*
        Run method will be executed after the application context is
        loaded and right before the Spring Application run method is
        completed.
     */

//    @PostConstruct
//    public void filltables(){
//
//
//
//    }

}