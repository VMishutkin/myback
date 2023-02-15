package ru.skypro.homework.model.dto.ads;

import lombok.Data;

import java.util.List;

@Data
public class AdsDto {
    int AuthorId;
    String Image;
    int pk;
    int price;
    String title;
}
