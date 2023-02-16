package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.model.dto.ads.*;
import ru.skypro.homework.model.entity.Ad;
import ru.skypro.homework.model.entity.Comment;
import ru.skypro.homework.model.entity.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;

import java.util.List;

@Service
public class AdsService {
    private final AdRepository adsRepository;
    private final Mapper mapper;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;



    public AdsService(AdRepository adsRepository, Mapper mapper, CommentRepository commentRepository, UserRepository userRepository) {
        this.adsRepository = adsRepository;
        this.mapper = mapper;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    public ResponseWrapperAds getAllAds() {
        ResponseWrapperAds ads =  new ResponseWrapperAds();
        List<Ad> adsFromBase = adsRepository.findAll();
        for (Ad ad: adsFromBase) {
            ads.getResults().add(mapper.adToAdsDto(ad));
            ads.setCount(ads.getResults().size());
        }

        return ads;
    }

    public Ad addAds(String username, CreateAds createAds) throws Exception{

        Ad ad = MapStructMapper.INSTANCE.createAdsToAd(createAds);
        User user = userRepository.findByUsername(username).orElseThrow();
        ad.setAuthor(user);
        user.getAds().add(ad);
        adsRepository.save(ad);
        return ad;
    }

    public List<CommentDto> getComments(int ad_pk) {
/*
    List<Comment> comments = commentRepository.findAllByPk();
        return comments.stream().map(MapStructMapper.INSTANCE::commentToCommentDto).collect(Collectors.toList());
*/
  return null;
    }



    public CommentDto addComment(int ad_pk, CommentDto commentDto) {
        Comment comment = MapStructMapper.INSTANCE.commentDtoToComment(commentDto);
        Ad ad = adsRepository.findById(ad_pk).orElseThrow();
        ad.addComment(comment);
        return null;
    }

    public FullAds getFullAd(int id) {
        Ad ad = adsRepository.findById(id).orElseThrow();
        return mapper.adsToFullAds(ad);

    }

    public void removeAd(int pk) {
        Ad ad = adsRepository.findById(pk).orElseThrow();
        adsRepository.delete(ad);
    }

    public CreateAds updateAds(int pk, CreateAds createAds) {
        Ad ad = adsRepository.findById(pk).orElseThrow();
        ad.setTitle(createAds.getTitle());
        ad.setPrice(createAds.getPrice());
        return createAds;
    }
}
