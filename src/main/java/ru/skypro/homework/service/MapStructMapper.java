package ru.skypro.homework.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.dto.user.UserDto;
import ru.skypro.homework.entity.User;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);
    User userDtoToUser(UserDto userDto);
    UserDto userToDtoUser(User userDto);
}
