package ru.skypro.homework.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.ads.AdsDto;
import ru.skypro.homework.dto.ads.CommentDto;
import ru.skypro.homework.dto.ads.CreateAds;
import ru.skypro.homework.dto.ads.FullAds;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.service.AdsService;

import java.util.List;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController

@RequestMapping("/ads")
public class AdsController {
    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }


    @GetMapping
    public List<AdsDto> getAllAds() {
        return adsService.getAllAds();
    }

    @PostMapping
    public Ad addAds(@RequestBody AdsDto dto) {
        return adsService.addAds(dto);
    }

    @GetMapping("/{ad_pl}/comments")
    public List<CommentDto> getComments(@PathVariable int ad_pk) {

        return adsService.getComments(ad_pk);
    }

    @PostMapping("/{ad_pk}/comments")
    public CommentDto addComment(@PathVariable int ad_pk, @RequestBody CommentDto comment) {

        return adsService.addComment(ad_pk, comment);
    }

    @GetMapping("/{pk}")
    public FullAds getFullAd(@PathVariable int pk) {
        return adsService.getFullAd(pk) ;
    }

    @DeleteMapping("/{id}")
    public void removeAds(@PathVariable int pk) {
        adsService.removeAd(pk);

    }

    @PatchMapping("/{pk}")
    public CreateAds updateAds(@PathVariable int pk, @RequestBody CreateAds createAds){

        return adsService.updateAds(pk, createAds);
    }
    @GetMapping("/{ad_pk}/comments/{id}")
    public CommentDto getComments(@PathVariable int ad_pk, @PathVariable int id){

        return null;
    }
    @DeleteMapping("/{ad_pk}/comments/{id}")
    public void deleteComments(@PathVariable int ad_pk, @PathVariable int id){

    }
    @PatchMapping("/{ad_pk}/comments/{id}")
    public CommentDto updateComments(@PathVariable int ad_pk, @PathVariable int id){
        return null;
    }
    @GetMapping("/me")
    public AdsDto getAdsme(@PathVariable int id){
        return null;
    }


}
