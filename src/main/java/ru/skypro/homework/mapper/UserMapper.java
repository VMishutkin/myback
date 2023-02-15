package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.model.dto.user.UserDto;
import ru.skypro.homework.model.entity.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

}
