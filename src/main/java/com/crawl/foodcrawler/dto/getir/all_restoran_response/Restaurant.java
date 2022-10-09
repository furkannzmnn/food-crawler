package com.crawl.foodcrawler.dto.getir.all_restoran_response;

import java.util.ArrayList;

public class Restaurant {
    public String id;
    public String name;
    public String slug;
    public String imageURL;
    public double ratingPoint;
    public String ratingCount;
    public boolean isFavorite;
    public ArrayList<Cuisine> cuisines;
    public String openClosedTime;
    public String openingClosingDate;
    public boolean isReviewEnabled;
    public ArrayList<PaymentOption> paymentOptions;
    public ArrayList<Object> infoItems;
    public ArrayList<WorkingHour> workingHours;
    public RestaurantRatings restaurantRatings;
    public boolean hasRealPhoto;
    public boolean isClosed;
    public String closedText;
    public Styles styles;

}
