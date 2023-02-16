package ru.skypro.homework.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.skypro.homework.model.dto.ads.AdsDto;
import ru.skypro.homework.model.dto.ads.CommentDto;
import ru.skypro.homework.model.dto.ads.CreateAds;
import ru.skypro.homework.model.dto.ads.FullAds;
import ru.skypro.homework.model.dto.user.UserDto;
import ru.skypro.homework.model.entity.Ad;
import ru.skypro.homework.model.entity.Comment;
import ru.skypro.homework.model.entity.User;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);
    @Mapping(source ="email", target = "username")
    User userDtoToUser(UserDto userDto);

    @Mapping(source ="username", target = "email")
    UserDto userToDtoUser(User user);

    AdsDto adsToAdsDto(Ad ads);


    Ad createAdsToAd(CreateAds createAds);

    Ad adsDtoToAds(AdsDto adsDto);

    CommentDto commentToCommentDto(Comment comment);

    Comment commentDtoToComment(CommentDto commentDto);

    FullAds adToFullAd(Ad ad);
}
