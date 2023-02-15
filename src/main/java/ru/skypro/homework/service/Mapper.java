package ru.skypro.homework.service;

import org.springframework.stereotype.Service;
import ru.skypro.homework.model.dto.ads.FullAds;
import ru.skypro.homework.model.entity.Ad;
import ru.skypro.homework.model.entity.User;
import ru.skypro.homework.repository.AdRepository;

@Service
public class Mapper {
    private final AdRepository adRepository;

    public Mapper(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public FullAds adsToFullAds(Ad ad){
       User user = ad.getAuthor();
        FullAds fullAd ;
        fullAd = MapStructMapper.INSTANCE.adToFullAd(ad);
        fullAd.setAuthorFirstName(user.getFirstName());
        fullAd.setAuthorLastName(user.getLastName());
        return fullAd;

}

}
