package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UserDto;
import ru.skypro.homework.dto.user.UserImage;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    @PostMapping("set_password")
    public NewPassword setPassword(@RequestBody NewPassword password){
        return null;
        //return userService.(password);
    }

    @GetMapping("/me/@{id}")
    public UserDto getuser(@PathVariable int id){
        return null;
    }
    @PatchMapping("/me")
    public UserDto updateUser(@RequestBody UserDto user){
        return null;
    }
    @PatchMapping("/me/image")
    public UserImage updateUserImage(String image){
        return null;
    }



}
