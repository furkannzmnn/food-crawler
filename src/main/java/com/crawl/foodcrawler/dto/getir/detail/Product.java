package com.crawl.foodcrawler.dto.getir.detail;

import java.util.ArrayList;

public class Product {
    public String id;
    public String name;
    public String priceText;
    public double price;
    public String struckPriceText;
    public int struckPrice;
    public String description;
    public String imageURL;
    public String fullScreenImageURL;
    public ArrayList<OptionCategory> optionCategories;
    public Restaurant restaurant;
    public String oldPrice;
}
