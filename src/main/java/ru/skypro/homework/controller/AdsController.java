package ru.skypro.homework.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.ads.AdsDto;
import ru.skypro.homework.dto.ads.Comment;
import ru.skypro.homework.dto.ads.CreateAds;
import ru.skypro.homework.dto.ads.FullAds;

import java.util.List;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {


    @GetMapping
    public AdsDto getAllAds(@PathVariable int id) {
        return null;
    }

    @PostMapping
    public AdsDto addAds(@RequestBody AdsDto dto) {
        return null;
    }

    @GetMapping("/{ad_pl}/comments")
    public List<Comment> getComments(@PathVariable int ad_pk) {
        return null;
    }

    @PostMapping("/{ad_pk}/comments")
    public Comment addComment(@PathVariable int ad_pk, @RequestBody Comment comment) {
        return null;
    }

    @GetMapping("/{id}")
    public FullAds getFullAd(@PathVariable int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void removeAds(@PathVariable int id) {

    }

    @PatchMapping("/{id}")
    public CreateAds updateAds(@PathVariable int id, @RequestBody CreateAds createAds){
        return null;
    }
    @GetMapping("/{ad_pk}/comments/{id}")
    public Comment getComments(@PathVariable int ad_pk, @PathVariable int id){
        return null;
    }
    @DeleteMapping("/{ad_pk}/comments/{id}")
    public void deleteComments(@PathVariable int ad_pk, @PathVariable int id){

    }
    @PatchMapping("/{ad_pk}/comments/{id}")
    public Comment updateComments(@PathVariable int ad_pk, @PathVariable int id){
        return null;
    }
    @GetMapping("/me")
    public AdsDto getAdsme(@PathVariable int id){
        return null;
    }


}
