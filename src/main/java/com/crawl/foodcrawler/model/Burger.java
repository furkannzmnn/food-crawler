package com.crawl.foodcrawler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "burger")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Burger {
    @Id
    private String id;
    private String name;
    private String priceText;
    private double price;
    private String description;
    private String imageURL;
    private String fullScreenImageURL;
    @Enumerated(value = EnumType.STRING)
    private CategoryType categoryType = CategoryType.BURGER;
}
