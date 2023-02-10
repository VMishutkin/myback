package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UserDto;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User updateUser(UserDto userDto){
        User newUser = MapStructMapper.INSTANCE.userDtoToUser(userDto);
        return userRepository.save(newUser);
    }

    public UserDto getUser(String name) {
        Optional<User> user= userRepository.findByName(name);
        if(user.isPresent())
            return MapStructMapper.INSTANCE.userToDtoUser(user.get());
        else
            return null;
    }

    public NewPassword setPassword(Authentication authentication, NewPassword password) {

        Optional<User> user= userRepository.findByName(authentication.getName());
        if(user.isPresent()) {
            User foundUser = user.get();
            if (foundUser.getP)
        }
        else
            return null;

    }
}