package ru.skypro.homework.dto.ads;

import lombok.Data;

@Data
public class CommentDto {
    int authorId;
    String createdAt;
    int pk;
    String text;

}
