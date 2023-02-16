package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.homework.model.dto.user.NewPassword;
import ru.skypro.homework.model.dto.user.UserDto;
import ru.skypro.homework.model.entity.User;
import ru.skypro.homework.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.encoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
    }

    public User updateUser(UserDto userDto){
        User newUser = MapStructMapper.INSTANCE.userDtoToUser(userDto);
        return userRepository.save(newUser);
    }

    public UserDto getUser(String name) {
        Optional<User> user= userRepository.findByUsername(name);
        if(user.isPresent())
            return MapStructMapper.INSTANCE.userToDtoUser(user.get());
        else
            return null;
    }

    public boolean setPassword(Authentication authentication, NewPassword password) {

        Optional<User> user= userRepository.findByUsername(authentication.getName());
        if(user.isPresent()) {
            User foundUser = user.get();
            if(encoder.matches(password.getCurrentPassword(), foundUser.getPassword().substring(8))){
            //if (foundUser.getPassword().equals(password.getCurrentPassword())){
                foundUser.setPassword("{bcrypt}"+ encoder.encode(password.getNewPassword()));
                userRepository.save(foundUser);
                return true;
            }
        }
            return false;
    }
}
