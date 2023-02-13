package ru.skypro.homework.dto.ads.user;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class NewPassword {
    String currentPassword;
    String newPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
