package ru.skypro.homework.dto.ads;

import lombok.Data;

import java.util.List;

@Data
public class FullAds {
    String authorFirstName;
    String authorLastName;
    String description;
    String email;
    List<String> image;
    String phone;
    int pk;
    int price;
    String Title;

}
