package ru.skypro.homework.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.dto.ads.*;
import ru.skypro.homework.model.entity.Ad;
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
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        ResponseWrapperAds adList = adsService.getAllAds();

        if(adList != null) {
            return ResponseEntity.status(200).body(adList);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Ad addAds(@RequestPart(value = "properties") CreateAds dto,
                     @RequestPart(value = "image")MultipartFile image,
                     Authentication authentication) throws Exception {
        return adsService.addAds(authentication.getName(), dto);
    }

    @GetMapping("/{ad_pk}/comments")
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
