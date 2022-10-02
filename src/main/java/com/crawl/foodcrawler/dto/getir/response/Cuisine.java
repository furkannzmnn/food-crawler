package com.crawl.foodcrawler.dto.getir.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Cuisine {
    public String id;
    public String name;
    public String imageURL;
    public boolean isVisibleRestaurantDetail;
    public boolean isVisibleCuisineCategory;
}
