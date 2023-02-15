package ru.skypro.homework.service;

import ru.skypro.homework.model.dto.user.RegisterReq;
import ru.skypro.homework.model.dto.user.Role;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterReq registerReq, Role role);
}
