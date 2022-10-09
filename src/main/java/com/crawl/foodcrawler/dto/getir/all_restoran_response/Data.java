package com.crawl.foodcrawler.dto.getir.all_restoran_response;

import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;

@Cacheable
public class Data {
    public Restaurant restaurant;
    public ArrayList<ProductCategory> productCategories;
}
