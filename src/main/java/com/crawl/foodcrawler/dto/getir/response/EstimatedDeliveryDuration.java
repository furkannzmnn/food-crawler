package com.crawl.foodcrawler.dto.getir.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstimatedDeliveryDuration {
    public String value;
    public Styles styles;
    public String suffix;
    public String title;

}
