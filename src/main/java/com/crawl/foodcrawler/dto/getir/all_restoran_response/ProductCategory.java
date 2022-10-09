package com.crawl.foodcrawler.dto.getir.all_restoran_response;

import java.util.ArrayList;

public class ProductCategory {
    public String id;
    public String name;
    public ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }
}
