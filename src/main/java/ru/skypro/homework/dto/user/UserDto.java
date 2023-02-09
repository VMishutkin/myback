package ru.skypro.homework.dto.user;

import lombok.Data;

@Data
public class UserDto {
    String email;
    String firstName;
    int id;
    String lastName;
    String phone;
    String regDate;
    String city;
    String image;
}
