package com.crawl.foodcrawler.dto.getir.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Item {
    public String id;
    public String name;
    public String slug;
    public String imageURL;
    public double ratingPoint;
    public String ratingCount;
    public List<Cuisine> cuisines;
    public ArrayList<PaymentOption> paymentOptions;
    public ArrayList<Object> infoItems;
    public ArrayList<Object> workingHours;
    public boolean hasRealPhoto;
    public String deliveryFee;
    public EstimatedDeliveryDuration estimatedDeliveryDuration;
    public MinBasketSize minBasketSize;
    public RestaurantMinBasketSize restaurantMinBasketSize;
    public ArrayList<Badge> badges;
    public ArrayList<DeliveryOption> deliveryOptions;
    public boolean isClosed;
    public String closedText;
    public Styles styles;

}
