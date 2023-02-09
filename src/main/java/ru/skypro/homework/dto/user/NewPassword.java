package ru.skypro.homework.dto.user;

import lombok.Data;

@Data
public class NewPassword {
    String currentPassword;
    String newPassword;
}
