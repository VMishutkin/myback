package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.model.dto.ads.AdsDto;
import ru.skypro.homework.model.dto.ads.FullAds;
import ru.skypro.homework.model.entity.Ad;
import ru.skypro.homework.model.entity.User;
import ru.skypro.homework.repository.AdRepository;

@Service
public class Mapper {


    public FullAds adsToFullAds(Ad ad){
       User user = ad.getAuthor();
        FullAds fullAd ;
        fullAd = MapStructMapper.INSTANCE.adToFullAd(ad);
        fullAd.setAuthorFirstName(user.getFirstName());
        fullAd.setAuthorLastName(user.getLastName());
        return fullAd;

}

    public AdsDto adToAdsDto(Ad ad) {
        AdsDto adsDto = new AdsDto();
        adsDto.setPk(ad.getPk());
        adsDto.setTitle(ad.getTitle());
        adsDto.setPrice(ad.getPrice());
        adsDto.setImage(ad.getImage());
        if (ad.getAuthor()!=null) {
            adsDto.setAuthorId(ad.getAuthor().getId());
        }
        return adsDto;
    }
}
