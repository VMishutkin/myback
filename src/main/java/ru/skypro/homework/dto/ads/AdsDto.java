package ru.skypro.homework.dto.ads;

import lombok.Data;

import java.util.List;

@Data
public class AdsDto {
    int AuthorId;
    List<String> Image;
    int pk;
    int price;
    String title;
}
