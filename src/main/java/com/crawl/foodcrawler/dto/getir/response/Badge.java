package com.crawl.foodcrawler.dto.getir.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Badge {
    public String iconURL;
    public String iconURL2x;
    public String iconURL3x;
    public Styles styles;
    public String text;
}
