package ru.skypro.homework.dto.ads;

import lombok.Data;

@Data
public class Comment {
    int authorId;
    String createdAt;
    int pk;
    String text;

}
