package ru.skypro.homework.model.dto.ads;

import lombok.Data;

@Data
public class CommentDto {
    int authorId;
    String createdAt;
    int pk;
    String text;

}
