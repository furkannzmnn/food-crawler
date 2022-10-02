package com.crawl.foodcrawler.dto.getir.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryOption {
    public int type;
    public boolean isSelected;
    public DeliveryType deliveryType;
    public MinBasketSize minBasketSize;
    public EstimatedDeliveryDuration estimatedDeliveryDuration;
    public DeliveryFee deliveryFee;
}
