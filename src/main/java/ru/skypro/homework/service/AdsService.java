package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.ads.AdsDto;
import ru.skypro.homework.dto.ads.CommentDto;
import ru.skypro.homework.dto.ads.CreateAds;
import ru.skypro.homework.dto.ads.FullAds;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdsService {
    private final AdRepository adsRepository;
    private final Mapper mapper;
    private final CommentRepository commentRepository;

    public AdsService(AdRepository adsRepository, Mapper mapper, CommentRepository commentRepository) {
        this.adsRepository = adsRepository;
        this.mapper = mapper;
        this.commentRepository = commentRepository;
    }

    public List<AdsDto> getAllAds() {
        List<Ad> ads = adsRepository.findAll();
        return ads.stream().map(MapStructMapper.INSTANCE::adsToAdsDto).collect(Collectors.toList());
    }

    public Ad addAds(AdsDto dto) {
        return adsRepository.save(MapStructMapper.INSTANCE.adsDtoToAds(dto));
    }

    public List<CommentDto> getComments(int ad_pk) {
    List<Comment> comments = commentRepository.findAllByPk();
        return comments.stream().map(MapStructMapper.INSTANCE::commentToCommentDto).collect(Collectors.toList());
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
