package ru.skypro.homework.model.dto.ads;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseWrapperAds {
    private int count;
    private List<AdsDto> results;
    public ResponseWrapperAds(){
        results = new ArrayList<AdsDto>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AdsDto> getResults() {
        return results;
    }

    public void setResults(List<AdsDto> results) {
        this.results = results;
    }
}
