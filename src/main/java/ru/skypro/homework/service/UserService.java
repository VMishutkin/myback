package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
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

    public UserService(PasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
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

    public NewPassword setPassword(Authentication authentication, NewPassword password) {

        Optional<User> user= userRepository.findByUsername(authentication.getName());
        if(user.isPresent()) {
            User foundUser = user.get();
            if(encoder.matches(password.getCurrentPassword(), foundUser.getPassword())){
            //if (foundUser.getPassword().equals(password.getCurrentPassword())){
                foundUser.setPassword(encoder.encode(password.getNewPassword()));
                userRepository.save(foundUser);
                return password;
            }
        }
            return null;
    }
}
