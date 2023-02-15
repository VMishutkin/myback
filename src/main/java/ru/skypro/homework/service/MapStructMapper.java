package ru.skypro.homework.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.model.dto.ads.AdsDto;
import ru.skypro.homework.model.dto.ads.CommentDto;
import ru.skypro.homework.model.dto.ads.FullAds;
import ru.skypro.homework.model.dto.user.UserDto;
import ru.skypro.homework.model.entity.Ad;
import ru.skypro.homework.model.entity.Comment;
import ru.skypro.homework.model.entity.User;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    User userDtoToUser(UserDto userDto);

    UserDto userToDtoUser(User userDto);

    AdsDto adsToAdsDto(Ad ads);

    Ad adsDtoToAds(AdsDto adsDto);

    CommentDto commentToCommentDto(Comment comment);

    Comment commentDtoToComment(CommentDto commentDto);

    FullAds adToFullAd(Ad ad);
}
