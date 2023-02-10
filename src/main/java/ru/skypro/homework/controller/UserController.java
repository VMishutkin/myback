package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UserDto;
import ru.skypro.homework.dto.user.UserImage;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.service.UserService;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("set_password")
    public NewPassword setPassword(Authentication authentication, @RequestBody NewPassword password){
        return userService.setPassword(authentication, password);
        //return userService.(password);
    }

    @GetMapping("/me")
    public UserDto getuser(Authentication authentication){

        return userService.getUser(authentication.getName());
    }

    @PatchMapping("/me")
    public User updateUser(@RequestBody UserDto user){
        return userService.updateUser(user);

    }
    @PatchMapping("/me/image")
    public UserImage updateUserImage(String image){
        return null;
    }



}
