package com.crawl.foodcrawler.dto.getir.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentOption {
    public String title;
    public String imageURL;
    public boolean isActive;
}
